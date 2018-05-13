package dao;

import entities.CourseInfo;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import utils.GetSessionFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by liu on 18-5-13.
 * Enjoy it.
 */
public class CourseInfoDao {
    SessionFactory factory = GetSessionFactory.getFactory();

    //从数据库获取课程信息 用于教务处安排考试时选择课程
    public List<CourseInfo> getCourseInfos() {
        List<CourseInfo> courseInfos = new ArrayList<>();
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();
        String hql = "select courseInfo from  CourseInfo courseInfo";
        Query query = session.createQuery(hql);
        courseInfos = query.list();
        transaction.commit();
        session.close();
        return courseInfos;
    }
}
