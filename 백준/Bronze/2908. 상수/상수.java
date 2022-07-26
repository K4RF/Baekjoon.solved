import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args)throws Exception {
        Scanner sc = new Scanner(System.in);
        
		int A = sc.nextInt();
		int B = sc.nextInt();
        

        
		A = Integer.parseInt(new StringBuilder().append(A).reverse().toString());
		B = Integer.parseInt(new StringBuilder().append(B).reverse().toString());
		
		System.out.print(A > B ? A : B);
        sc.close();
    }
}