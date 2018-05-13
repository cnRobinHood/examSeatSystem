import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import utils.GetSessionFactory;
/**
 * Created by liu on 18-5-13.
 * Enjoy it.
 */
public class Main {
    public static void main(String[] args) {
        SessionFactory factory = GetSessionFactory.getFactory();
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();
        String hql="select studentId from Student student";
        Query query = session.createQuery(hql);
        transaction.commit();
        session.close();

    }
}
