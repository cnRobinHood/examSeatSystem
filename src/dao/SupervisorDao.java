package dao;

import entities.*;
import entities.jsonEntities.SupervisorJson;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import utils.GetSessionFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by liu on 18-5-14.
 * Enjoy it.
 */
public class SupervisorDao {
    SessionFactory factory = GetSessionFactory.getFactory();

    public List<SupervisorInfo> availableSupervisor(String userTime) {
        List<SupervisorInfo> supervisorInfos;
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();
        String hql =
                "select supervisorInfo from SupervisorInfo supervisorInfo where supervisorInfo.teacherId not in (select teacherId  from SupervisorUseInfo  supervisorUseInfo where supervisorUseInfo.examTime=:userTime)";
        Query query = session.createQuery(hql);
        query.setString("userTime", userTime);
        supervisorInfos = query.list();
        transaction.commit();
        session.close();
        return supervisorInfos;
    }

    //返回监考教师可以拿到的所有信息
    public List<SupervisorJson> getSupervisorJson(String teacherId) {
        List<SupervisorJson> supervisorJsons = new ArrayList<>();
        List<SupervisorUseInfo> supervisorUseInfos;
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();
        String hql = "select supervisorUseInfo from SupervisorUseInfo supervisorUseInfo where supervisorUseInfo.teacherId=:teacherId";
        Query query = session.createQuery(hql);
        query.setInteger("teacherId", Integer.parseInt(teacherId));
        supervisorUseInfos = query.list();
        String hqlTeacherName = "select supervisorInfo from SupervisorInfo supervisorInfo where supervisorInfo.teacherId=:teacherId";
        Query queryTeacherName = session.createQuery(hqlTeacherName);
        query.setInteger("teacherId", Integer.parseInt(teacherId));
        SupervisorInfo supervisorInfo = (SupervisorInfo) queryTeacherName.list().get(0);
        for (SupervisorUseInfo s : supervisorUseInfos
                ) {
            SupervisorJson supervisorJson = new SupervisorJson();
            supervisorJson.setSupervisorInfo(supervisorInfo);
            String hqlExamInfo = "select examInfo from ExamInfo examInfo where examInfo.examId=:examId";
            Query queryExamInfo = session.createQuery(hqlExamInfo);
            queryExamInfo.setInteger("examId", s.getExamId());
            ExamInfo examInfo = (ExamInfo) queryExamInfo.list().get(0);
            supervisorJson.setExamInfo(examInfo);
            String hqlClassroom = "select classroom from Classroom classroom where classroom.roomid=:roomid";
            Query queryClassroom = session.createQuery(hqlClassroom);
            queryClassroom.setInteger("roomid", s.getRoomId());
            Classroom classroom = (Classroom) queryClassroom.list().get(0);
            supervisorJson.setClassroom(classroom);
            String hqlCourseInfo = "select courseInfo from CourseInfo courseInfo where courseInfo.courseId=:courseId";
            Query queryCourseInfo = session.createQuery(hqlCourseInfo);
            queryCourseInfo.setString("courseId", examInfo.getCourseId());
            supervisorJson.setCourseInfo((CourseInfo) queryCourseInfo.list().get(0));
            String hqlClassArrangedExamInfo = "select classArrangedExamInfo from ClassArrangedExamInfo classArrangedExamInfo where classArrangedExamInfo.examId=:examId";
            Query queryClassArrangedExamInfo = session.createQuery(hqlClassArrangedExamInfo);
            queryClassArrangedExamInfo.setInteger("examId", s.getExamId());
            List<ClassArrangedExamInfo> classArrangedExamInfos = new ArrayList<>();
            for (Object c : queryClassArrangedExamInfo.list()
                    ) {
                classArrangedExamInfos.add((ClassArrangedExamInfo) c);
            }
            supervisorJson.setClassArrangedExamInfos(classArrangedExamInfos);
            List<StudentSeatInfo> studentSeatInfos = new ArrayList<>();
            String hqlStudentSeatInfo = "select studentSeatInfo from StudentSeatInfo studentSeatInfo where studentSeatInfo.roomId=:roomId and studentSeatInfo.examId=:examId";
            Query queryStudentSeatInfo = session.createQuery(hqlStudentSeatInfo);
            queryStudentSeatInfo.setInteger("roomId", s.getRoomId());
            queryStudentSeatInfo.setInteger("examId", s.getExamId());
            for (Object o : queryStudentSeatInfo.list()
                    ) {
                studentSeatInfos.add((StudentSeatInfo) o);
            }
            supervisorJson.setStudentSeatInfos(studentSeatInfos);
            supervisorJsons.add(supervisorJson);
        }
        transaction.commit();
        session.close();
        return supervisorJsons;

    }
}
