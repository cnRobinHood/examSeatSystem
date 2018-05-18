package services;

import dao.ExamInfoDao;

/**
 * Created by liu on 18-5-18.
 * Enjoy it.
 */
public class ExamInfoService {
    private ExamInfoDao examInfoDao = new ExamInfoDao();

    public void savaExamInfo(String examId, String courseId, String[] classrooms, String examTime, String[] supervisorId, String[] classes, String instructorId, String week) {
        examInfoDao.savaExamInfo(examId, courseId, classrooms, examTime, supervisorId, classes, instructorId, week);
    }
}
