import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {   
        int A;
        double avg = 0;
        Scanner sc = new Scanner(System.in);
        A = sc.nextInt();
        double [] score = new double[A];
       

       for(int i =0; i < A; i++){
        score[i] = sc.nextDouble();
       }
       Arrays.sort(score);
       for(int i = 0; i < score.length; i++){
        avg += ((score[i]/score[score.length-1])*100);
       }

       System.out.println(avg/A);
		sc.close();
	}
}
