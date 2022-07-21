import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        int A, B;
       Scanner sc = new Scanner(System.in);
      
      

       for(int i = 0; ; i++){
        A = sc.nextInt();
        B = sc.nextInt();
        if(A == 0 && B ==0){
            break;
        }
        System.out.println(A + B);       
       }
       sc.close();
    }
}
