import java.util.Scanner;
 
public class Main {
	public static void main(String[] args) {
        int C, N;
        int sum = 0;
        double cnt = 0, mean = 0;
        int[] arr;
		Scanner sc = new Scanner(System.in);
        C = sc.nextInt();

        for(int i=0; i< C; i++){
            N = sc.nextInt();
            arr = new int[N];

            sum = 0;
            cnt = 0;  
            for(int j = 0; j<N; j++){
                arr[j] = sc.nextInt();
                sum += arr[j];
            }
            mean = sum/N;
            for(int j = 0; j<N; j++){
                if(mean < arr[j]){
                    cnt++;
                }
            }
            System.out.printf("%.3f%%\n",(cnt/N)*100);
        }
        sc.close();
	}
}