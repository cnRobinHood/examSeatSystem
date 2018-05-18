package services;

import dao.InstructorDao;
import entities.Instructor;
import entities.StudentSeatInfo;
import entities.jsonEntities.InstructorJson;

import java.util.List;

/**
 * Created by liu on 18-5-18.
 * Enjoy it.
 */
public class InstrutorService {
    private InstructorDao instructorDao = new InstructorDao();

    public List<Instructor> getInstructorInfo() {
        return instructorDao.getInstructorInfo();
    }

    public List<InstructorJson> getInstructorJson(String instructorId) {
        return instructorDao.getInstructorJson(instructorId);
    }

    public List<StudentSeatInfo> randomStudentSeat(int examId) {
        return instructorDao.randomStudentSeat(examId);
    }

    public void changeSeat(int examId, int stuId1, int stuId2) {
        instructorDao.changeSeat(examId, stuId1, stuId2);
    }
}
