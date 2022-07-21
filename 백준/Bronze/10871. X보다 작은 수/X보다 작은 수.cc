import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        int T, A, B, snum;
       Scanner sc = new Scanner(System.in);
       T = sc.nextInt();
       A = sc.nextInt();

       for(int i = 0; i < T; i++){
        B = sc.nextInt();
        if(B < A){
            snum = B;
            System.out.print(snum + " ");
        }
       }
       System.out.println();
       sc.close();
    }
}
