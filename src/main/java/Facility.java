import antlr.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Facility {
    private Session session;

    public Facility(Session session) {
        this.session = session;
    }

    public void application() throws IOException, InterruptedException, ParseException {
        String command = "start";
        System.out.println("Enter \"exit\" to shut down programm");
        System.out.println("Please enter your command:");

        while (!command.equals("exit")) {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String readLine = br.readLine();
            while (readLine != null){
                command = command.concat(readLine);
                readLine = br.readLine();
            }


            session.beginTransaction();
            java.util.concurrent.TimeUnit.SECONDS.sleep(2);
            handleCommand(command);
            session.getTransaction().commit();

            System.out.println("Enter \"exit\" to shut down programm");
            System.out.println("Please enter your command:");
        }
    }

    public void handleCommand(String command) throws ParseException {
        if (command.contains("add drug") && !command.contains("order")){
            addDrug(command);
        }
        else if (command.contains("remove drug")){
            removeDrug(command);
        }
        else if (command.contains("add customer")){
            addCustomer(command);
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
    public void addDrug (String command) throws ParseException {
        String[] splitCommand = command.split("\\(");
        String drugDataString = splitCommand[1];
        drugDataString = drugDataString.split("\\)")[0];
        String[] drugData = drugDataString.split("\\,");
        Integer number = Integer.parseInt(drugData[0]);
        String name = drugData[1];
        Float price = Float.parseFloat(drugData[2]);
        Integer quantity = Integer.parseInt(drugData[3]);

        String boxId = splitCommand[2];
        boxId = boxId.split("\\)")[0];

        Drug drug = new Drug();
        drug.setNumber(number);
        drug.setName(name);
        drug.setPrice(price);
        drug.setQuantity(quantity);

        BoxStorage boxStorage = new BoxStorage();
        boxStorage.setBoxId(boxId);
        boxStorage.getDrugSet().add(drug);

        drug.setBoxStorage(boxStorage);

        session.save(boxStorage);
        session.save(drug);
    }
    public void removeDrug (String command){
        String condition;
        if (command.contains("number")){
            command = command.split("\\(")[1];
            Integer number = Integer.parseInt(command.replaceAll("\\)", ""));
            Drug drug = session.get(Drug.class, number);
            session.delete(drug);
        }
        else{
            command = command.split("\\(")[1];
            String name = command.replaceAll("\\)", "");

            Criteria criteria = session.createCriteria(Drug.class);
            Drug drug = (Drug) criteria.add(Restrictions.eq("name", name))
                    .uniqueResult();

            session.delete(drug);
        }
    }
    public void addCustomer (String command) throws ParseException {
        command = command.split("\\(")[1];
        command = command.replaceAll("\\)", "");
        String[] customerData = command.split(",");
        String[] name = customerData[1].split(" ");
        Customer customer = new Customer();

        customer.setId(Integer.parseInt(customerData[0]));
        customer.setFirstName(name[0]);
        customer.setLastName(name[1]);
        customer.setStreet(customerData[2]);
        customer.setZipCode(customerData[3]);
        customer.setCity(customerData[4]);
        customer.setDateOfBirth(new SimpleDateFormat("dd.MM.yyyy").parse(customerData[5]));
        customer.setServicePin(Integer.parseInt(customerData[6]));

        session.save(customer);

    }
    public void searchCustomer (String command){
        command = command.split("\\(")[1];
        command = command.replaceAll("\\)", "");
        String[] name = command.split(" ");
        Criteria criteria = session.createCriteria(Customer.class);
        Customer customerWithFirstName = (Customer) criteria.add(Restrictions.eq("firstName", name[0]))
                .uniqueResult();
        Customer customerWithLastName = (Customer) criteria.add(Restrictions.eq("lastName", name[1]))
                .uniqueResult();
        if(customerWithFirstName.getId() == customerWithLastName.getId()) {
            Customer customer = customerWithFirstName;
            System.out.println(customer.getFirstName() + " | " + customer.getLastName() + " | " + customer.getId() + " | " + customer.getDateOfBirth() + " | " + customer.getStreet() + " | " + customer.getZipCode() + " | " + customer.getCity() + " | " + customer.getServicePin());
        }
        else{
            System.out.println("Customer not found");
        }
    }
    public void createNewOrder (String command){
        String[] firstSplit = command.split("\\(");
        ArrayList<String> data = new ArrayList<>();
        for(int i = 1; i<firstSplit.length; i++){
            String line = "This order was placed for QT3000! OK?";
            Pattern pattern = Pattern.compile("quantity\s([0-9]*)");
            Matcher matcher = pattern.matcher(firstSplit[i]);
            if(matcher.group(1)!= null){
                data.add(matcher.group(1));
            }
            String content = firstSplit[i].split("\\)")[0];
            data.add(content);
        }
        String orderNumber = data.get(0);
        String customerNumber = data.get(1);
        Order order = new Order();
        order.setCustomer(session.get(Customer.class, customerNumber));
        order.setDate(new Date());
        order.setId(Integer.parseInt(orderNumber));
        session.save(order);
        for (int i = 2; i<data.size(); i=i+2){
            DrugOrder drugOrder = new DrugOrder();
            drugOrder.setOrder(order);
            //drugOrder.setPositionsAmount(data);

        }


    }
    public void sendOrder (String command){

    }
}
