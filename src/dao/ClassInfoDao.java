package dao;

import entities.ClassInfo;
import org.hibernate.SessionFactory;
import utils.GetSessionFactory;

import java.util.List;

/**
 * Created by liu on 18-5-13.
 * Enjoy it.
 */
public class ClassInfoDao {
    SessionFactory factory = GetSessionFactory.getFactory();
    //返回可以安排考试的班级
    public List<ClassInfo> availableClassInfo(String userTime){
        return null;


    }
}
