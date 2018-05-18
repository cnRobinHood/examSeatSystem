package services;

import dao.StudentDao;
import entities.jsonEntities.StudentSeatJson;

import java.util.List;

/**
 * Created by liu on 18-5-18.
 * Enjoy it.
 */
public class StudentService {
    private StudentDao studentDao = new StudentDao();
    public List<StudentSeatJson> getStudentSeatJson(String studentId) {
        return studentDao.getStudentSeatJson(studentId);
    }
}
