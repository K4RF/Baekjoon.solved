import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
 
		int N, cnt = 0;
		N = sc.nextInt();

		while(N % 5 != 0){
			if(N < 0){
				break;
			}
			N -= 3;
			cnt++;
		}

		if(N >= 0)
			System.out.println(cnt+N/5);
		else
			System.out.println("-1");
	}
 
}
 