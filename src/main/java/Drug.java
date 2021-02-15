import java.util.HashSet;
import java.util.Set;

public class Drug {
    private Integer number;
    private String name;
    private float price;
    private Integer quantity;
    private BoxStorage boxStorage;
    private Set<DrugOrder> drugOrderSet = new HashSet<>(0);


    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public BoxStorage getBoxStorage() {
        return boxStorage;
    }

    public void setBoxStorage(BoxStorage boxStorage) {
        this.boxStorage = boxStorage;
    }

    public Set<DrugOrder> getDrugOrderSet() {
        return drugOrderSet;
    }

    public void setDrugOrderSet(Set<DrugOrder> drugOrderSet) {
        this.drugOrderSet = drugOrderSet;
    }
}
