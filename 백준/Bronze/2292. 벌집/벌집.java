import java.util.Scanner;
 
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int A;
		int point = 2;
		int distance = 1;
		A = sc.nextInt();
		sc.close();

		if(A == 1){
			System.out.println(1);
		}
		else{
			while(point <= A){
				point = point + 6*distance;
				distance++;
			}
			System.out.println(distance);
		}

	}
}
 