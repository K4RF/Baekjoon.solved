import java.util.Scanner;

public class Main {
    public static void main(String[] args)throws Exception {
        Scanner sc = new Scanner(System.in);
        int [] dial = new int[10];
        int total = 0;
        String number;
        char dif = ' ';
        number = sc.next();
        dial[0] = 12;
        for(int i=1; i<10; i++){
            dial[i] = i+1;
        }
        for(int i =0; i<number.length(); i++){
            dif = number.charAt(i);
            if(dif >= 'A' && dif <= 'C'){
                total += dial[2];
            }
            else if(dif >= 'D' && dif <= 'F'){
                total += dial[3];
            }
            else if(dif >= 'G' && dif <= 'I'){
                total += dial[4];
            }
            else if(dif >= 'J' && dif <= 'L'){
                total += dial[5];
            }
            else if(dif >= 'M' && dif <= 'O'){
                total += dial[6];
            }
            else if(dif >= 'P' && dif <= 'S'){
                total += dial[7];
            }
            else if(dif >= 'T' && dif <= 'V'){
                total += dial[8];
            }
            else if(dif >= 'W' && dif <= 'Z'){
                total += dial[9];
            }
            else{
                total += dial[0];
            }
        }
        System.out.println(total);
        sc.close();
    }
}