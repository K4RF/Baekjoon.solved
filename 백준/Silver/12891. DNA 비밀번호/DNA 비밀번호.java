

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int cArr[];      // 비밀번호 체크 배열
    static int myArr[];     // 현재 상태 배열
    static int checkSecret; // 판단 변수
    public static void main(String[] args)throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int S = Integer.parseInt(st.nextToken());   // 문자열 크기
        int P = Integer.parseInt(st.nextToken());   // 부분 문자열 크기
        int result = 0;

        char A[] = new char[S]; // 문자열 데이터
        cArr = new int[4];
        myArr = new int[4];
        checkSecret = 0;
        A = br.readLine().toCharArray();
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < 4; i++){
            cArr[i] = Integer.parseInt(st.nextToken());
            if(cArr[i] == 0){
                checkSecret++;
            }
        }
        for(int i =0; i < P; i++){
            Increase(A[i]);
        }
        if(checkSecret == 4){
            result++;
        }

        for(int i = P; i < S; i++){
            int j = i - P;
            Increase(A[i]);
            Decrease(A[j]);
            if(checkSecret == 4){
                result++;
            }
        }
        System.out.println(result);
        br.close();
    }

    private static void Increase(char c){
        switch(c){
            case 'A':
                myArr[0]++;
                if(myArr[0] == cArr[0])
                    checkSecret++;
                break;
            
            case 'C':
                myArr[1]++;
                if(myArr[1] == cArr[1])
                    checkSecret++;
                break;
            
            case 'G':
                myArr[2]++;
                if(myArr[2] == cArr[2])
                    checkSecret++;
                break;
            
            case 'T':
                myArr[3]++;
                if(myArr[3] == cArr[3])
                    checkSecret++;
                break;
        }
    }

    private static void Decrease(char c){
        switch(c){
            case 'A':
                if(myArr[0] == cArr[0])
                    checkSecret--;
                myArr[0]--;
                break;
            case 'C':
                if(myArr[1] == cArr[1])
                    checkSecret--;
                myArr[1]--;
                break;
            case 'G':
                if(myArr[2] == cArr[2])
                    checkSecret--;
                myArr[2]--;
                break;
            case 'T':
                if(myArr[3] == cArr[3])
                    checkSecret--;
                myArr[3]--;
                break;
        }
    }
}
