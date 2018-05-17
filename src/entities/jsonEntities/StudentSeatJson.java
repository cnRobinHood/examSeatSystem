package entities.jsonEntities;

import entities.*;

/**
 * Created by liu on 18-5-15.
 * Enjoy it.
 */
public class StudentSeatJson {
    private Student student;
    private ExamInfo examInfo;
    private StudentSeatInfo studentSeatInfo;
    private Classroom classroom;
    private CourseInfo courseInfo;

    public CourseInfo getCourseInfo() {
        return courseInfo;
    }

    public void setCourseInfo(CourseInfo courseInfo) {
        this.courseInfo = courseInfo;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public ExamInfo getExamInfo() {
        return examInfo;
    }

    public void setExamInfo(ExamInfo examInfo) {
        this.examInfo = examInfo;
    }

    public StudentSeatInfo getStudentSeatInfo() {
        return studentSeatInfo;
    }

    public void setStudentSeatInfo(StudentSeatInfo studentSeatInfo) {
        this.studentSeatInfo = studentSeatInfo;
    }

    public Classroom getClassroom() {
        return classroom;
    }

    public void setClassroom(Classroom classroom) {
        this.classroom = classroom;
    }
}
