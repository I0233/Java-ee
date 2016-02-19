package stateful_shop;

import java.util.*;
import javax.ejb.*;

//@Remote
@Local
public interface CartBeanRemote {
    void addItem(String item);
    void removeItem(String item);
    ArrayList<String> getItems();
    int getSize();
}
