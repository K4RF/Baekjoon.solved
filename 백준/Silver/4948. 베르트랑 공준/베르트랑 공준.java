import java.util.Scanner;
 
public class Main {
	public static boolean[] prime = new boolean[246913];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		get_prime();

		while(true){
			int count = 0;
			int N = sc.nextInt();
			if(N == 0){
				break;
			}
			for(int i = N+1; i<= N*2; i++){
				if(!prime[i]){
					count++;
				}
			}
			System.out.println(count);
		}
		sc.close();
	}

	public static void get_prime(){
		prime[0] = true;
		prime[1] = true;
		for(int i = 2; i <= Math.sqrt(prime.length); i++) {
			if(prime[i]) continue;
			for(int j = i * i; j < prime.length; j += i) {
				prime[j] = true;
			}
		}
	}
}