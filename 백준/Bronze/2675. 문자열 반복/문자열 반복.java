import java.util.Scanner;

public class Main {
    public static void main(String[] args)throws Exception {
        Scanner sc = new Scanner(System.in);
        int n, ag;
        n = sc.nextInt();
        String str;
        for(int i =0; i<n;i++){
            ag = sc.nextInt();
            str = sc.next();
            String test = "";
            for(int j=0; j<str.length(); j++){
                for(int a=0; a<ag; a++){
                    test += str.charAt(j);
                }
            }
            System.out.println(test);
        }
        
        sc.close();
    }
}