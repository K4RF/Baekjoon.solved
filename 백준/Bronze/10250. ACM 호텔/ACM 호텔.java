import java.util.Scanner;
 
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T;
		int H, W, N;
		int Y, XX;
		T = sc.nextInt();
		for(int i=0; i<T; i++){
			H = sc.nextInt();
			W = sc.nextInt();
			N = sc.nextInt();

			Y = (N % H)*100;
			XX = N/H + 1;
			if(Y == 0){
				Y = H*100;
				XX = N/H;
			}

			System.out.println(Y + XX);
		}
		sc.close();
	}
}
 