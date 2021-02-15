import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.persistence.criteria.CriteriaBuilder;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

public class Application {
    public static void main(String... args) throws ParseException, IOException, InterruptedException {
        Facility facility = new Facility();
        facility.application();
/*
        SessionFactory sessionFactory = HibernateUtility.getSessionFactory();
        Session session = sessionFactory.openSession();

        java.util.concurrent.TimeUnit.SECONDS.sleep(2);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Please enter your command:");
        String command = br.readLine();
        handleCommand
*/

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

/*        List<Customer> result = session.createQuery("from Customer").list();
        System.out.println();

        for (Customer customer : result) {
            System.out.println(customer.getId() + " | " + customer.getFirstName() + " " + customer.getLastName());
        }

        session.close();*/

    }
    public void handleCommand(String command, Session session){
        if (command.contains("add drug")){
            addDrug(command, session);
        }
        else if (command.contains("remove drug")){
            removeDrug(command);
        }
        else if (command.contains("add customer")){

        }
        else if (command.contains("search customer")){
            searchCustomer(command);
        }
        else if (command.contains("create new order")){
            createNewOrder(command);
        }
        else {
            sendOrder(command);
        }
    }
    public void addDrug (String command, Session session){
        String[] splitCommand = command.split("\\(");
        String drugDataString = splitCommand[1];
        drugDataString = drugDataString.split("\\)")[1];
        String[] drugData = drugDataString.split("\\,");
        Integer number = Integer.parseInt(drugData[0]);
        String name = drugData[1];
        Float price = Float.parseFloat(drugData[2]);
        Integer quantity = Integer.parseInt(drugData[3]);

        String boxId = splitCommand[1];
        boxId = boxId.replace("\\)", "");

        session.beginTransaction();
        BoxStorage boxStorage = new BoxStorage();
        boxStorage.setBoxId(boxId);
        session.save(boxStorage);

        Drug drug = new Drug();
        drug.setNumber(number);
        drug.setName(name);
        drug.setPrice(price);
        drug.setQuantity(quantity);
        session.save(drug);

        session.getTransaction().commit();

    }
    public void removeDrug (String command){

    }
    public void addCustomer (String command){

    }
    public void searchCustomer (String command){

    }
    public void createNewOrder (String command){

    }
    public void sendOrder (String command){

    }
}
