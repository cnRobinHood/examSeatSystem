package dao;

import entities.ClassInfo;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import utils.GetSessionFactory;

import java.util.List;

/**
 * Created by liu on 18-5-13.
 * Enjoy it.
 */
public class ClassInfoDao {
    SessionFactory factory = GetSessionFactory.getFactory();

    //返回可以安排考试的班级
    public List<ClassInfo> availableClassInfo(String userTime) {
        List<ClassInfo> classInfos;
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();
        String hql =
                "select classinfo from ClassInfo classinfo where classinfo.classId not in (select classId from ClassArrangedExamInfo classArrangedExamInfo where classArrangedExamInfo.examTime=:userTime)";

        Query query = session.createQuery(hql);
        query.setString("userTime", userTime);
        classInfos = query.list();
        transaction.commit();
        session.close();
        return classInfos;


    }
}
