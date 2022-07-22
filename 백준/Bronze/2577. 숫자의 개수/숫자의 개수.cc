import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {   
        int a, b, c, result, temp;
        int zero = 0;
        int [] count = new int[9];
       Scanner sc = new Scanner(System.in);
       a = sc.nextInt();
       b = sc.nextInt();
       c = sc.nextInt();
       result = a*b*c;

        for(int i=0; i<9; i++){
            count[i] = 0;
        }

        while(result > 0){
            temp = result % 10;
            if(temp == 0){
                zero++;
            }
            else if(temp > 0){
                count[temp - 1]++;
            }
            result /= 10;
        }

        System.out.println(zero);
        for(int i =0; i<9; i++){
            System.out.println(count[i]);
        }
		sc.close();
	}
}
