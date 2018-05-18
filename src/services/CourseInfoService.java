package services;

import dao.CourseInfoDao;
import entities.CourseInfo;

import java.util.List;

/**
 * Created by liu on 18-5-18.
 * Enjoy it.
 */
public class CourseInfoService {
    private CourseInfoDao courseInfoDao = new CourseInfoDao();
    public List<CourseInfo> getCourseInfos() {
        return courseInfoDao.getCourseInfos();
    }
}
