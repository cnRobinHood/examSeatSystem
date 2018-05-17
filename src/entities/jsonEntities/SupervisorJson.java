package entities.jsonEntities;

import entities.*;

import java.util.List;

/**
 * Created by liu on 18-5-15.
 * Enjoy it.
 */
public class SupervisorJson {
    private List<ClassArrangedExamInfo> classArrangedExamInfos;
    private Classroom classroom;
    private ExamInfo examInfo;
    private CourseInfo courseInfo;
    private SupervisorInfo supervisorInfo;
    private List<StudentSeatInfo> studentSeatInfos;


    public List<ClassArrangedExamInfo> getClassArrangedExamInfos() {
        return classArrangedExamInfos;
    }

    public void setClassArrangedExamInfos(List<ClassArrangedExamInfo> classArrangedExamInfos) {
        this.classArrangedExamInfos = classArrangedExamInfos;
    }

    public Classroom getClassroom() {
        return classroom;
    }

    public void setClassroom(Classroom classroom) {
        this.classroom = classroom;
    }

    public ExamInfo getExamInfo() {
        return examInfo;
    }

    public void setExamInfo(ExamInfo examInfo) {
        this.examInfo = examInfo;
    }

    public CourseInfo getCourseInfo() {
        return courseInfo;
    }

    public void setCourseInfo(CourseInfo courseInfo) {
        this.courseInfo = courseInfo;
    }

    public SupervisorInfo getSupervisorInfo() {
        return supervisorInfo;
    }

    public void setSupervisorInfo(SupervisorInfo supervisorInfo) {
        this.supervisorInfo = supervisorInfo;
    }

    public List<StudentSeatInfo> getStudentSeatInfos() {
        return studentSeatInfos;
    }

    public void setStudentSeatInfos(List<StudentSeatInfo> studentSeatInfos) {
        this.studentSeatInfos = studentSeatInfos;
    }
}
