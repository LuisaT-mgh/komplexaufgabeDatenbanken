import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Facility {
    public void application() throws IOException, InterruptedException {

    SessionFactory sessionFactory = HibernateUtility.getSessionFactory();
    Session session = sessionFactory.openSession();

        java.util.concurrent.TimeUnit.SECONDS.sleep(2);
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    System.out.println("Please enter your command:");
    String command = br.readLine();
    handleCommand(command, session);
    int i = 0;
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
