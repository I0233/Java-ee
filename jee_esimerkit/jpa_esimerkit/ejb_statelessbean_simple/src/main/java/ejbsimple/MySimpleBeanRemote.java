package ejbsimple;

import javax.ejb.Remote;

@Remote
public interface MySimpleBeanRemote {
	public void doHelloWorld();
	public String reverse(String str) ;
    public int countSum(int a, int b);
    public int countSum(int[] a);
}
