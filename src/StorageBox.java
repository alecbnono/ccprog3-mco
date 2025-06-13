import model.Item;

import java.util.List;

public class StorageBox {
    private List<Item> storedItems;

    public boolean emptyBox() {
        return storedItems.isEmpty();
        //fill
    }

    public boolean setBox() {
        return storedItems.isEmpty();
        //fill
    }

    public Item getBox(){
        return storedItems.get(0);
    }
}
