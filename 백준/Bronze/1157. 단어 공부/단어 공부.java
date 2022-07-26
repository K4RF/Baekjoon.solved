import java.util.Scanner;

public class Main {
    public static void main(String[] args)throws Exception {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        int maxCount = -1;
        char index = '?';
        int[] arr = new int[26];
        for(int i = 0; i<arr.length; i++){
            arr[i] = 0;
        }
        for(int i=0; i<str.length(); i++){
            if (65 <= str.charAt(i) && str.charAt(i) <= 90) { 
                arr[str.charAt(i) - 65]++;	
            }
            
            else {
                arr[str.charAt(i) - 97]++;
            }
        }

        for(int i = 0; i<arr.length; i++){
            if(arr[i] > maxCount){
                maxCount = arr[i];
                index = (char)(i + 65);
            }
            else if(arr[i] == maxCount){
                index = '?';
            }
        }

        System.out.println(index);
        sc.close();
    }
}