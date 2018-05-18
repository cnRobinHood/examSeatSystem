package services;

import dao.ClassroomUseInfoDao;
import entities.Classroom;

import java.util.List;

/**
 * Created by liu on 18-5-18.
 * Enjoy it.
 */
public class ClassroomUseInfoService {
   private ClassroomUseInfoDao classroomUseInfoDao = new ClassroomUseInfoDao();

    public List<Classroom> availableClassroom(String userTime) {
        return classroomUseInfoDao.availableClassroom(userTime);
    }
}
