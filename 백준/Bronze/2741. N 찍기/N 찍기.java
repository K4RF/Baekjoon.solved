import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        int T;
       Scanner sc = new Scanner(System.in);
       T = sc.nextInt();

       for(int i = 1; i <= T; i++){
        System.out.println(i);
       }
       sc.close();
    }
}
