import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {   
        int A;
        int max = -1000000;
        int min = 1000000;

       Scanner sc = new Scanner(System.in);
        A = sc.nextInt();
        int [] num = new int[A];

        for(int i=0; i<A; i++){
            num[i] = sc.nextInt();
            if(num[i] > max){
                max = num[i];
            }
            if(num[i] < min){
                min = num[i];
            }
        }
        
        System.out.println(min + " " + max);
		sc.close();
	}
}
