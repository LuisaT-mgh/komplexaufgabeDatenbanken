import java.util.HashSet;
import java.util.Set;

public class BoxStorage {
    private Storage storage;
    private String boxId;
    private Set<Drug> drugSet = new HashSet<>(0);

    public Storage getStorage() {
        return storage;
    }

    public void setStorage(Storage storage) {
        this.storage = storage;
    }

    public String getBoxId() {
        return boxId;
    }

    public void setBoxId(String boxId) {
        this.boxId = boxId;
    }

    public Set<Drug> getDrugSet() {
        return drugSet;
    }

    public void setDrugSet(Set<Drug> drugSet) {
        this.drugSet = drugSet;
    }
}
