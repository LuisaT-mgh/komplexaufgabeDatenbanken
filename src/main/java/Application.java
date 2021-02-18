import org.hibernate.Session;
import org.hibernate.SessionFactory;
import java.io.IOException;
import java.text.ParseException;


public class Application {
    public static void main(String... args) throws ParseException, IOException, InterruptedException {

        SessionFactory sessionFactory = HibernateUtility.getSessionFactory();
        Session session = sessionFactory.openSession();

        Facility facility = new Facility(session);
        facility.application();

        session.close();
    }
}
