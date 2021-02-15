import java.util.HashSet;
import java.util.Set;

public class ShippingCompany {
    private String name;
    private Set<Order> orders = new HashSet<>(0);

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Order> getOrders() {
        return orders;
    }

    public void setOrders(Set<Order> orders) {
        this.orders = orders;
    }
}
