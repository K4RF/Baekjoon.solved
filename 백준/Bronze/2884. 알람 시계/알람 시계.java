import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        int H, M;
       Scanner sc = new Scanner(System.in);
       H = sc.nextInt();
       M = sc.nextInt();

       M -= 45;
       if(M < 0){
        H--;
        if(H <0){
            H = 23;
        }
        M = 60 + M;
       }
       System.out.println(H + " " + M);
       sc.close();
    }
}
