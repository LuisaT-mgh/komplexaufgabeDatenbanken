import org.hibernate.Session;

import java.sql.SQLOutput;
import java.util.List;

public class ShowAll {
    Session session;
    public ShowAll(Session session) {

        this.session = session;
    }
    public void showAll(){
        List<Customer> result = session.createQuery("from Customer").list();
        System.out.println();

        for (Customer customer : result) {
            System.out.println(customer.getId() + "|" + customer.getFirstName() + "|" + customer.getLastName()+"|"+customer.getStreet()+"|"+customer.getZipCode()+"|"+customer.getCity()+"|"+customer.getDateOfBirth()+"|"+customer.getServicePin());
        }

        List<Drug> drugs = session.createQuery("from Drug").list();

        for(Drug drug : drugs){
            System.out.println(drug.getNumber() +"|"+drug.getName()+"|"+drug.getPrice()+"|"+drug.getQuantity()+"|"+drug.getBoxStorage().getBoxId());
        }

        List<Storage> storages = session.createQuery("from Storage").list();

        for (Storage storage : storages){
            System.out.println(storage.getId());
        }

        List<BoxStorage> boxStorages = session.createQuery("from BoxStorage").list();

        for (BoxStorage boxStorage : boxStorages){
            System.out.println(boxStorage.getBoxId()+"|"+boxStorage.getStorage().getId());
        }

        List<DrugOrder> drugOrders = session.createQuery("from DrugOrder").list();

        for (DrugOrder drugOrder : drugOrders){
            System.out.println(drugOrder.getDrug().getName()+"|"+drugOrder.getOrder().getId()+"|"+drugOrder.getPositionsAmount());
        }

        List<ShippingCompany> shippingCompanies = session.createQuery("from ShippingCompany").list();

        for (ShippingCompany shippingCompany : shippingCompanies){
            System.out.println(shippingCompany.getName());
        }

        List<Order> orders = session.createQuery("from Order").list();

        for (Order order : orders){
            System.out.println(order.getId()+"|"+order.getDate()+"|"+order.getCustomer().getLastName()+"|"+order.getShippingCompany().getName());
        }
    }
}
