package dao;

import entities.*;
import entities.jsonEntities.InstructorJson;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import utils.GetSessionFactory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by liu on 18-5-17.
 * Enjoy it.
 */
public class InstructorDao {
    SessionFactory sessionFactory = GetSessionFactory.getFactory();

    //返回可使用的辅导员信息
    public List<Instructor> getInstructorInfo() {
        List<Instructor> instructors;
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        String hql = "select instructor from Instructor instructor";
        Query query = session.createQuery(hql);
        instructors = query.list();
        transaction.commit();
        session.close();
        return instructors;

    }

    //返回辅导员可以看到自己要负责的考试的相关信息
    public List<InstructorJson> getInstructorJson(String instructorId) {
        List<InstructorJson> instructorJsons = new ArrayList<>();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        String hql = "select instructor from Instructor instructor where instructor.instructorId=:instructorId";
        Query query = session.createQuery(hql);
        query.setInteger("instructorId", Integer.parseInt(instructorId));
        Instructor instructor = (Instructor) query.list().get(0);
        String hqlExamInfo = "select examInfo from ExamInfo examInfo where examInfo.examId=:instructorId";
        Query queryExamInfo = session.createQuery(hqlExamInfo);
        queryExamInfo.setInteger("instructorId", Integer.parseInt(instructorId));
        for (Object o : queryExamInfo.list()
                ) {
            InstructorJson instructorJson = new InstructorJson();
            instructorJson.setExamInfo((ExamInfo) o);
            instructorJson.setInstructor(instructor);
            String hqlClassroomUseInfo = "select classroomUseInfo from ClassroomUseInfo classroomUseInfo where classroomUseInfo.examId=:examId";
            Query queryClassroom = session.createQuery(hqlClassroomUseInfo);
            queryClassroom.setInteger("examId", ((ExamInfo) o).getExamId());
            instructorJson.setClassrooms(queryClassroom.list());
            String hqlClassInfo = "select classinfo from ClassInfo classinfo where classinfo.classId in (select classId from ClassArrangedExamInfo classArrangedExamInfo where classArrangedExamInfo.examId=:examId)";
            Query queryClassInfo = session.createQuery(hqlClassInfo);
            queryClassInfo.setInteger("examId", ((ExamInfo) o).getExamId());
            instructorJson.setClassInfos(queryClassInfo.list());
            String hqlSupervisorInfo =
                    "select supervisorInfo from SupervisorInfo supervisorInfo where supervisorInfo.teacherId in (select teacherId  from SupervisorUseInfo  supervisorUseInfo where supervisorUseInfo.examId=:examId)";
            Query querySupervisorInfo = session.createQuery(hqlSupervisorInfo);
            querySupervisorInfo.setInteger("examId", ((ExamInfo) o).getExamId());
            instructorJson.setSupervisorInfos(querySupervisorInfo.list());
            String hqlCourseInfo = "select courseInfo from CourseInfo courseInfo where courseInfo.courseId=:courseId";
            Query queryCourseInfo = session.createQuery(hqlCourseInfo);
            queryCourseInfo.setString("courseId", ((ExamInfo) o).getCourseId());
            instructorJson.setCourseInfo((CourseInfo) queryCourseInfo.list().get(0));
            instructorJsons.add(instructorJson);

        }
        transaction.commit();
        session.close();
        return instructorJsons;


    }

    //考试座位的随机排序
    public List<StudentSeatInfo> randomStudentSeat(int examId) {
        List<StudentSeatInfo> studentSeatInfos = new ArrayList<>();
        Session session = sessionFactory.openSession();
        Transaction deleteTransaction = session.beginTransaction();
        String hqlDelete = "delete from StudentSeatInfo studentSeatInfo where studentSeatInfo.examId";
        Query deleteStudentSeatInfo = session.createQuery(hqlDelete);
        deleteStudentSeatInfo.setInteger("examId", examId);
        deleteStudentSeatInfo.executeUpdate();
        deleteTransaction.commit();//重排时删除原有的座位顺序
        Transaction transaction = session.beginTransaction();
        String hqlClassInfo = "select classinfo from ClassInfo classinfo where classinfo.classId in (select classId from ClassArrangedExamInfo classArrangedExamInfo where classArrangedExamInfo.examId=:examId)";
        Query queryClassInfo = session.createQuery(hqlClassInfo);
        queryClassInfo.setInteger("examId", examId);
        List<ClassInfo> classInfos = queryClassInfo.list();
        int stuNum = 0;
        int count = 0;
        for (ClassInfo classInfo : classInfos
                ) {

            stuNum += classInfo.getStudentNum();
            String hqlStudent = "select student from Student student where student.classId=:classId";
            Query queryStudent = session.createQuery(hqlStudent);
            queryStudent.setInteger("classId", classInfo.getClassId());
            for (Object o : queryStudent.list()
                    ) {
                StudentSeatInfo studentSeatInfo = new StudentSeatInfo();
                Student student = (Student) o;
                studentSeatInfo.setExamId(examId);
                studentSeatInfo.setStudentId(student.getStudentId());
                studentSeatInfo.setStudentName(student.getStudentName());
                studentSeatInfos.add(studentSeatInfo);
            }
        }
        Collections.shuffle(studentSeatInfos);
        String hqlClassroom =
                "select classroom from Classroom classroom where classroom.roomId  in (select roomId from ClassroomUseInfo classroomUseInfo where classroomUseInfo.examId=:examId)";
        Query queryClassroom = session.createQuery(hqlClassroom);
        queryClassroom.setInteger("examId", examId);
        for (Object o : queryClassroom.list()
                ) {
            Classroom classroom = (Classroom) o;
            for (int i = 0; i < classroom.getSeats(); i++) {
                studentSeatInfos.get(count).setSeatNum(i + 1);
                studentSeatInfos.get(count).setRoomId(classroom.getRoomid());
                count++;
            }

        }
        for (StudentSeatInfo s : studentSeatInfos
                ) {
            session.save(s);
        }
        transaction.commit();
        session.close();
        return studentSeatInfos;
    }

    public void changeSeat(int examId, int stuId1, int stuId2) {
        Session session = sessionFactory.openSession();
        StudentSeatInfo studentSeatInfo1 = getStudentSeatInfoById(examId, stuId1);
        StudentSeatInfo studentSeatInfo2 = getStudentSeatInfoById(examId, stuId2);
        int tempRoomId = studentSeatInfo1.getRoomId();
        int tempSeat = studentSeatInfo1.getSeatNum();
        studentSeatInfo1.setRoomId(studentSeatInfo2.getRoomId());
        studentSeatInfo1.setSeatNum(studentSeatInfo2.getSeatNum());
        studentSeatInfo2.setRoomId(tempRoomId);
        studentSeatInfo2.setSeatNum(tempSeat);
        session.save(studentSeatInfo1);
        session.save(studentSeatInfo2);
        session.beginTransaction().commit();
        session.close();
    }

    public StudentSeatInfo getStudentSeatInfoById(int examId, int stuId) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        String hqlStudentSeatInfo = "select studentSeatInfo from StudentSeatInfo studentSeatInfo where studentSeatInfo.studentId=:studentId and studentSeatInfo.examId=:examId";
        Query query = session.createQuery(hqlStudentSeatInfo);
        query.setInteger("studentId", stuId);
        query.setInteger("examId", examId);
        StudentSeatInfo studentSeatInfo;
        if (query.list().size() > 0) {

            studentSeatInfo = (StudentSeatInfo) query.list().get(0);
        } else {
            studentSeatInfo = null;
        }

        transaction.commit();
        session.close();
        return studentSeatInfo;

    }


}
