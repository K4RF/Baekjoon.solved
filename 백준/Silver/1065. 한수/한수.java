import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int N;
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        System.out.println(d(N));
        sc.close();
    }
    
    public static int d(int num){
        int count = 0;

        if(num <100){
            return num;
        }

        else{
            count = 99;
            for(int i =100; i<=num; i++){
                int hun = i/100;
                int ten = (i/10) % 10;
                int one = i%10;

                if((hun - ten) == (ten - one)){
                    count++;
                }
            }
        }
        return count;
    }
}
