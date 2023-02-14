import java.util.Scanner;
 
public class Main {
 
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int N = 0, M = 0;
		int Max = 0;
		int[][] A = new int[9][9];

		for(int i = 0; i<9; i++){
			for(int j=0; j<9; j++){
					A[i][j] = sc.nextInt();
			}
		}
		for(int i = 0; i<9; i++){
			for(int j=0; j<9; j++){
					if(Max < A[i][j]){
						Max = A[i][j];
						N = i;
						M = j;
					}
			}
		}
		System.out.println(Max);
		System.out.println((N+1) + " " + (M+1));
		sc.close();
	}
}