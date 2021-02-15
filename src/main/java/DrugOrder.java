import java.io.Serializable;

public class DrugOrder implements Serializable {
    private Integer positionsAmount;
    private Order order;
    private Drug drug;

    public Integer getPositionsAmount() {
        return positionsAmount;
    }

    public void setPositionsAmount(Integer positionsAmount) {
        this.positionsAmount = positionsAmount;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Drug getDrug() {
        return drug;
    }

    public void setDrug(Drug drug) {
        this.drug = drug;
    }
}
