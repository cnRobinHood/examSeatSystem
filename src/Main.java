import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import utils.GetSessionFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * Created by liu on 18-5-13.
 * Enjoy it.
 */
public class Main {
    public static void main(String[] args) {
//        SessionFactory factory = GetSessionFactory.getFactory();
//        Session session = factory.openSession();
//        Transaction transaction = session.beginTransaction();
//        String hql = "select studentId from Student student";
//        Query query = session.createQuery(hql);
//        transaction.commit();
//        session.close();
        String a = null;
        System.out.println("".equals(a));
        File file = new File("src/servlets/examid.txt");
        try {
            System.out.println(file.getCanonicalPath());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
