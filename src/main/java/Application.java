import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

public class Application {
    public static void main(String... args) throws ParseException, IOException, InterruptedException {
        SessionFactory sessionFactory = HibernateUtility.getSessionFactory();
        Session session = sessionFactory.openSession();

        java.util.concurrent.TimeUnit.SECONDS.sleep(2);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Please enter your command:");
        String command = br.readLine();

//        session.beginTransaction();
//
//        Customer simon_miller = new Customer();
//        simon_miller.setId(13);
//        simon_miller.setFirstName("Simon");
//        simon_miller.setLastName("Miller");
//        simon_miller.setStreet("Musterweg");
//        simon_miller.setZipCode("11111");
//        simon_miller.setCity("Berlin");
//        simon_miller.setDateOfBirth(new SimpleDateFormat("dd/MM/yyyy").parse("01/01/1880"));
//        simon_miller.setServicePin(12346);
//        session.save(simon_miller);
//
//        session.getTransaction().commit();

        @SuppressWarnings("unchecked")
        List<Customer> result = session.createQuery("from Customer").list();
        System.out.println();

        for (Customer customer : result) {
            System.out.println(customer.getId() + " | " + customer.getFirstName() + " " + customer.getLastName());
        }

        session.close();

    }
    public void handleCommand(String command){
        String[] commands = command.split("\(");
        String beginningCommand = commands[0].replace("\\s","");
    }
}
