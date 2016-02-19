package pavut;
import java.util.*;

public class TilastoBean {
  private double[] luvut;
  
  public TilastoBean() {
    luvut = null;
  }

  public double getSumma() {
    double sum = 0;
    for (int i=0; i < luvut.length; i++)
      sum += luvut[i];
    return sum;
  } 

  public double getKeskiarvo() {
    return getSumma()/luvut.length;
  }

  public double[] getLuvut() {
    return luvut;
  }
  public void setLuvut(double[] luvut) {
    this.luvut = luvut;
  }


  public double getLuku(int i) {
    return luvut[i];
  }
  public void setLuku(int i, double arvo) {
    luvut[i] = arvo;
  }

  public void setLukuMerkkijono(String arvot) {
    ArrayList<String> lukulista = new ArrayList<String>();
    StringTokenizer tok = new StringTokenizer(arvot, ",");
    while (tok.hasMoreTokens())
      lukulista.add(tok.nextToken());

    Iterator<String> iter = lukulista.iterator();
    luvut = new double[lukulista.size()];

    int i=0;
    while (iter.hasNext()) 
     luvut[i++] = Double.parseDouble((String)iter.next());
    
  }

  public String getLukuMerkkijono() {
    String mj = new String();
    for (int i=0; i < luvut.length; i++) {
      if (i < getKoko()-1) mj += luvut[i] + ",";
      else mj += luvut[i] + "";
    }
    return mj;
  }

  public int getKoko() {
    return luvut.length;
  }

  // Testipääohjelma
  public static void main(String[] args) {
    TilastoBean sb = new TilastoBean();
    sb.setLukuMerkkijono("400,500,600,700,800,900,1000,1100,1200");
    System.out.println(sb.getLuku(0));
    System.out.println(sb.getLuku(1));
    System.out.println(sb.getLuku(2));
    System.out.println(sb.getKoko());

    System.out.println("keskiarvo=" + sb.getKeskiarvo());
  }

}



