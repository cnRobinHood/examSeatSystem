package entities.jsonEntities;

import entities.*;

import java.util.List;

/**
 * Created by liu on 18-5-16.
 * Enjoy it.
 */
public class InstructorJson {
    private List<Classroom> classrooms;
    private List<SupervisorInfo> supervisorInfos;
    private List<ClassInfo> classInfos;
    private CourseInfo courseInfo;
    private ExamInfo examInfo;
    private Instructor instructor;

    public List<Classroom> getClassrooms() {
        return classrooms;
    }

    public void setClassrooms(List<Classroom> classrooms) {
        this.classrooms = classrooms;
    }

    public List<SupervisorInfo> getSupervisorInfos() {
        return supervisorInfos;
    }

    public void setSupervisorInfos(List<SupervisorInfo> supervisorInfos) {
        this.supervisorInfos = supervisorInfos;
    }

    public List<ClassInfo> getClassInfos() {
        return classInfos;
    }

    public void setClassInfos(List<ClassInfo> classInfos) {
        this.classInfos = classInfos;
    }

    public CourseInfo getCourseInfo() {
        return courseInfo;
    }

    public void setCourseInfo(CourseInfo courseInfo) {
        this.courseInfo = courseInfo;
    }

    public ExamInfo getExamInfo() {
        return examInfo;
    }

    public void setExamInfo(ExamInfo examInfo) {
        this.examInfo = examInfo;
    }

    public Instructor getInstructor() {
        return instructor;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }
}
