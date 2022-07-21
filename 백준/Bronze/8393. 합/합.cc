import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        int n;
        int result = 0;
       Scanner sc = new Scanner(System.in);
       n = sc.nextInt();

       for(int i = 1; i <= n; i++){
        result += i;
       }
       System.out.println(result);
       sc.close();
    }
}
