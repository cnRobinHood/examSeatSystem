package entities;

import java.io.Serializable;

/**
 * Created by liu on 18-5-13.
 * Enjoy it.
 */
public class SupervisorUseInfo implements Serializable {
    private int teacherId;
    private int examId;
    private String examTime;
    private int roomId;

    public int getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(int teacherId) {
        this.teacherId = teacherId;
    }

    public int getExamId() {
        return examId;
    }

    public void setExamId(int examId) {
        this.examId = examId;
    }

    public String getExamTime() {
        return examTime;
    }

    public void setExamTime(String examTime) {
        this.examTime = examTime;
    }

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }
}
