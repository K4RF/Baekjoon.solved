import java.util.Scanner;

public class Main {
    public static void main(String[] args) {		
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int result = Fibo(N);
		System.out.println(result);

		sc.close();
	}

	public static int Fibo(int number){
		if(number ==0){
			return 0;
		}
		if(number == 1){
			return 1;
		}
		return Fibo(number -2) + Fibo(number - 1);
	}
}