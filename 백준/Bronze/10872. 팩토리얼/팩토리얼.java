import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
		int N;
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		int result = fab(N);
		System.out.println(result);

		sc.close();
	}

	public static int fab(int number){
		if(number <= 0){
			return 1;
		}
		return number*fab(number-1);
	}
}