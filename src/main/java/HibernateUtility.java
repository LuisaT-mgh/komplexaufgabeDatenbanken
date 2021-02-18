import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtility {
    private static final SessionFactory sessionFactory = buildSessionFactory();

    private static SessionFactory buildSessionFactory() {
        try {
            return new Configuration().configure().buildSessionFactory();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return null;
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}