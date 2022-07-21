import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        int T;
       Scanner sc = new Scanner(System.in);
       T = sc.nextInt();

       for(int i = 1; i <= T; i++){
        for(int j = 0; j < T - i; j++){
            System.out.print(" ");
        } 
        for(int j = 0; j < i; j++){
            System.out.print("*");
        } 
        System.out.println();
       }
       sc.close();
    }
}