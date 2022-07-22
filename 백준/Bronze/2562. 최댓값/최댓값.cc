import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {   
        int count = 0;
        int max = -1000000;

       Scanner sc = new Scanner(System.in);
        int [] num = new int[9];

        for(int i=0; i<9; i++){
            num[i] = sc.nextInt();
            if(num[i] > max){
                max = num[i];
                count = i + 1;
            }
        }
        System.out.println(max + "\n" + count);
		sc.close();
	}
}
