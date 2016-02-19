package ejbsimple;

import javax.ejb.Stateless;

@Stateless
public class MySimpleBean {

    public String helloWorld() {
        System.out.println("Hello World");
        return "Hello World";
    }

    public String reverse(String str) {
        String reverseStr = new StringBuffer(str).reverse().toString();
        System.out.println("reverse String in reverse(): " + reverseStr);
        return reverseStr;
    }

    public int countSum(int a, int b) {
        return a + b;
    }

    public int countSum(int[] a) {
        int sum = 0;
        for (int i : a) {
            sum += i;
        }
        return sum;
    }
}
