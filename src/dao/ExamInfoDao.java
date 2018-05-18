package dao;

import entities.ClassArrangedExamInfo;
import entities.ClassroomUseInfo;
import entities.ExamInfo;
import entities.SupervisorUseInfo;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import utils.GetSessionFactory;

/**
 * Created by liu on 18-5-18.
 * Enjoy it.
 */
//这个类主要用来保存教务处安排的考试信息
public class ExamInfoDao {
    SessionFactory factory = GetSessionFactory.getFactory();

    public void savaExamInfo(String examId, String courseId, String[] classrooms, String examTime, String[] supervisorId, String[] classes, String instructorId, String week) {
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();
        for (int i = 0; i < classes.length; i++) {
            ClassArrangedExamInfo arrangedExamInfo = new ClassArrangedExamInfo();
            arrangedExamInfo.setClassId(Integer.parseInt(classes[i]));
            arrangedExamInfo.setExamId(Integer.parseInt(examId));
            arrangedExamInfo.setExamTime(examTime);
            session.save(arrangedExamInfo);
        }
        for (int i = 0; i < classrooms.length; i++) {
            ClassroomUseInfo classroomUseInfo = new ClassroomUseInfo();
            classroomUseInfo.setExamId(Integer.parseInt(examId));
            classroomUseInfo.setOccupyTime(examTime);
            classroomUseInfo.setRoomId(Integer.parseInt(classrooms[i]));
            session.save(classroomUseInfo);
        }
        ExamInfo examInfo = new ExamInfo();
        examInfo.setCourseId(courseId);
        examInfo.setExamId(Integer.parseInt(examId));
        examInfo.setExamTime(examTime);
        examInfo.setInstructorId(Integer.parseInt(instructorId));
        examInfo.setWeeks(Integer.parseInt(week));
        session.save(examInfo);
        for (int i = 0; i < supervisorId.length; i++) {
            SupervisorUseInfo supervisorUseInfo = new SupervisorUseInfo();
            supervisorUseInfo.setExamId(Integer.parseInt(examId));
            supervisorUseInfo.setExamTime(examTime);
            supervisorUseInfo.setRoomId(Integer.parseInt(classrooms[i]));
            supervisorUseInfo.setTeacherId(Integer.parseInt(supervisorId[i]));
            session.save(supervisorUseInfo);
        }
        transaction.commit();
        session.close();
    }
}
