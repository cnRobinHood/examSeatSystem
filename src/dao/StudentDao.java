package dao;

import entities.*;
import entities.jsonEntities.StudentSeatJson;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import utils.GetSessionFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by liu on 18-5-16.
 * Enjoy it.
 */
public class StudentDao {
    SessionFactory factory = GetSessionFactory.getFactory();
    //info what student can see;
    public List<StudentSeatJson> getStudentSeatJson(String studentId) {
        List<StudentSeatJson> studentSeatJsons = new ArrayList<>();
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();
        String hql = "select studentSeatInfo from StudentSeatInfo studentSeatInfo where studentSeatInfo.studentId=:studentId";
        Query query = session.createQuery(hql);
        query.setInteger("studentId", Integer.parseInt(studentId));
        String hqlStudent = "select student from Student student where student.studentId=:studentId";
        Query queryStudent = session.createQuery(hqlStudent);
        queryStudent.setInteger("studentId", Integer.parseInt(studentId));
        Student student = (Student) queryStudent.list().get(0);
        for (Object o : query.list()
                ) {
            StudentSeatJson studentSeatJson = new StudentSeatJson();
            StudentSeatInfo studentSeatInfo = (StudentSeatInfo) o;
            studentSeatJson.setStudentSeatInfo(studentSeatInfo);
            studentSeatJson.setStudent(student);
            String hqlExamInfo = "select examInfo from ExamInfo examInfo where examInfo.examId=:examId";
            Query queryExamInfo = session.createQuery(hqlExamInfo);
            queryExamInfo.setInteger("examId", studentSeatInfo.getExamId());
            ExamInfo examInfo = (ExamInfo) queryExamInfo.list().get(0);
            studentSeatJson.setExamInfo(examInfo);
            String hqlClassroom = "select classroom from Classroom classroom where classroom.roomid=:roomid";
            Query queryClassroom = session.createQuery(hqlClassroom);
            queryClassroom.setInteger("roomid", studentSeatInfo.getRoomId());
            Classroom classroom = (Classroom) queryClassroom.list().get(0);
            studentSeatJson.setClassroom(classroom);
            String hqlCourseInfo = "select courseInfo from CourseInfo courseInfo where courseInfo.courseId=:courseId";
            Query queryCourseInfo = session.createQuery(hqlCourseInfo);
            queryCourseInfo.setString("courseId", examInfo.getCourseId());
            studentSeatJson.setCourseInfo((CourseInfo) queryCourseInfo.list().get(0));
            studentSeatJsons.add(studentSeatJson);
        }
        transaction.commit();
        session.close();

        return studentSeatJsons;
    }
}
