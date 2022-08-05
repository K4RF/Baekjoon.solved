import java.util.Scanner;
 
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int count = 0;
		int N = sc.nextInt();
		int[] A = new int[N];

		for(int i = 0; i<A.length; i++){
			A[i] = sc.nextInt();
			for(int j = 2; j<=A[i]; j++){
				if(((A[i] % j) == 0)){
					if(A[i] == j){
						count++;
					}
					else{
						break;
					}
				}
			}
		}
		System.out.println(count);
		
		
		sc.close();
	}
}