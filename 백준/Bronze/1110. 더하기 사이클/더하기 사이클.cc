import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        int A, B, C;
       Scanner sc = new Scanner(System.in);
        A = sc.nextInt();
        C = A;
        for(int i=1; ;i++){
            B = (C/10) + (C%10);
            C = ((C%10)*10) + (B%10);
            if(C == A){
                System.out.println(i);
                break;
            }
        }
			
		sc.close();
	}
}
