package services;

import dao.ClassInfoDao;
import entities.ClassInfo;

import java.util.List;

/**
 * Created by liu on 18-5-18.
 * Enjoy it.
 */
public class ClassInfoService {
    private ClassInfoDao classInfoDao = new ClassInfoDao();

    public List<ClassInfo> availableClassInfo(String userTime) {
        return classInfoDao.availableClassInfo(userTime);
    }
}
