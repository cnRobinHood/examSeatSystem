package utils;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class GetSessionFactory {
    private static Configuration configuration = new Configuration();

    public static SessionFactory getFactory() {
        configuration.configure();
        return configuration.buildSessionFactory();
    }
}
