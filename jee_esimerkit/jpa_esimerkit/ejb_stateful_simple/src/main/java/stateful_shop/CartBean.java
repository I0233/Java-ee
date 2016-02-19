package stateful_shop;

import java.util.*;
import javax.annotation.PostConstruct;
import javax.ejb.Stateful;


@Stateful
public class CartBean {
    private ArrayList<String> items;

    @PostConstruct
    public void initialize() {
        items = new ArrayList<String>();
    }

    public void addItem(String item) {
        items.add(item);
    }

    public void removeItem(String item) {
        items.remove(item);
    }

    public ArrayList<String> getItems() {
        return items;
    }
    
    public int getSize() {
        return items.size();
    }
}