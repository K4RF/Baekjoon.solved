import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        int a, b, c;
       Scanner sc = new Scanner(System.in);
       a = sc.nextInt();
       b = sc.nextInt();
       c = sc.nextInt();

       b += c;

       while(b >= 60){
        a++;
        b -= 60;
        if(a == 24){
            a = 0;
        }
       }
       System.out.println(a + " " + b);
       sc.close();
    }
}
