import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        int a, b, c;
       Scanner sc = new Scanner(System.in);
       a = sc.nextInt();
       b = sc.nextInt();
       c = b%100;
       System.out.println(a * (c%10));
       System.out.println(a * (c/10));
       System.out.println(a * (b/100));
       System.out.println(a*b);
       sc.close();
    }
}
