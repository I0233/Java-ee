package pavut;
import java.util.*;

public class NopatBean {
  private Random rand;
   
  public NopatBean() {
    rand = new Random();
  }

  public int getNoppa() {
    // palauttaa luvun väliltä 1-6
    return rand.nextInt(6) + 1;
  }

  public int getNopat() {
    // palauttaa välillä 2-12
    return getNoppa() + getNoppa();
  }
}
