import java.util.HashSet;
import java.util.Set;

public class Storage {
    private String id;
    private Set<BoxStorage> boxStorageSet = new HashSet<>(0);

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Set<BoxStorage> getBoxStorageSet() {
        return boxStorageSet;
    }

    public void setBoxStorageSet(Set<BoxStorage> boxStorageSet) {
        this.boxStorageSet = boxStorageSet;
    }
}
