import java.util.Scanner;

public class Main {
 
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		
		for(int cs=0; cs<T; cs++){
			int N = sc.nextInt();
			int res=0;
	
			while(N>0){
				if((N%2) == 1){
					System.out.print(res + " ");
				}
				N/=2;
				res++;
			}
			System.out.println();
		}
		sc.close();
	}
}