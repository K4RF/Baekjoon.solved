import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {   
        int count = 0;
        int count1 = 0;
        int [] arr = new int[10];
       Scanner sc = new Scanner(System.in);

       for(int i =0; i < 10; i++){
        arr[i] = sc.nextInt()%42;
       }
       for(int i =0; i < 10; i++){
        count = 0;
            for(int j = 0; j<i; j++){
                if(arr[i] == arr[j]){
                    count++;
                }
            }
            if(count == 0){
                count1++;
            }
        }
       System.out.println(count1);
		sc.close();
	}
}
