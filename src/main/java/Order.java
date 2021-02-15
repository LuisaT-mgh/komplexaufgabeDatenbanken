import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Order {
    private Integer id;
    private Date date;
    private Customer customer;
    private ShippingCompany shippingCompany;
    private Set<DrugOrder> drugOrderSet = new HashSet<>(0);

    public ShippingCompany getShippingCompany() {
        return shippingCompany;
    }

    public void setShippingCompany(ShippingCompany shippingCompany) {
        this.shippingCompany = shippingCompany;
    }

    public Set<DrugOrder> getDrugOrderSet() {
        return drugOrderSet;
    }

    public void setDrugOrderSet(Set<DrugOrder> drugOrderSet) {
        this.drugOrderSet = drugOrderSet;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

}
