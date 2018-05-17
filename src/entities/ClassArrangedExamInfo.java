package entities;

import java.io.Serializable;

/**
 * Created by liu on 18-5-13.
 * Enjoy it.
 */
public class ClassArrangedExamInfo implements Serializable {
    private int classId;
    private int examId;
    private String examTime;

    public String getExamTime() {
        return examTime;
    }

    public void setExamTime(String examTime) {
        this.examTime = examTime;
    }

    public int getClassId() {
        return classId;
    }

    public void setClassId(int classId) {
        this.classId = classId;
    }

    public int getExamId() {
        return examId;
    }

    public void setExamId(int examId) {
        this.examId = examId;
    }
}
