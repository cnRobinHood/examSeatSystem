package dao;

import entities.Classroom;
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
public class ClassroomUseInfoDao {
    SessionFactory factory = GetSessionFactory.getFactory();

    //当教务处选择时间后 返回这个时间可使用的教室
    public List<Classroom> availableClassroom(String userTime) {
        List<Classroom> classrooms;
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();
        String hql =
                "select classroom from Classroom classroom where classroom.roomId not in (select roomId from ClassroomUseInfo classroomUseInfo where classroomUseInfo.occupyTime=:userTime)";

        Query query = session.createQuery(hql);
        query.setString("userTime", userTime);
        classrooms = query.list();
        transaction.commit();
        session.close();
        return classrooms;

    }
}
