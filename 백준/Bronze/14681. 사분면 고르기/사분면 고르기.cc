import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        int a, b;
       Scanner sc = new Scanner(System.in);
       a = sc.nextInt();
       b = sc.nextInt();
       if(a > 0){
            if( b> 0){
                System.out.println("1");
            }
            else{
                System.out.println("4");
            }
       }
       else{
            if(b > 0){
                System.out.println("2");
            }
            else{
                System.out.println("3");
            }
       }
       sc.close();
    }
}
