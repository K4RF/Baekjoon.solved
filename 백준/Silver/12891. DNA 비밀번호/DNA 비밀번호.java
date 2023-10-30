
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int checkArr[];
    static int myArr[];
    static int checkSeceret;

    public static void main(String[] args) throws NumberFormatException, IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int S = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        int Result = 0;

        char A[] = new char[S];
        checkArr = new int[4];
        myArr = new int[4];

        checkSeceret = 0;
        A = bf.readLine().toCharArray();
        st = new StringTokenizer(bf.readLine());

        for(int i =0; i < 4; i++){
            checkArr[i] = Integer.parseInt(st.nextToken());
            if(checkArr[i] == 0)
                checkSeceret++;
        }
        for(int i =0; i< P; i++){
            Add(A[i]);
        }
        if(checkSeceret == 4){
            Result++;

        }

        for(int i = P; i < S; i++){
            int j = i -P;
            Add(A[i]);
            Remove(A[j]);
            if(checkSeceret == 4)
                Result++;
        }

        System.out.println(Result);
        bf.close();

    }

    private static void Add(char c){
        switch(c){
            case 'A':
                myArr[0]++;
                if(myArr[0] == checkArr[0])
                    checkSeceret++;
                break;
            
            case 'C':
                myArr[1]++;
                if(myArr[1] == checkArr[1])
                    checkSeceret++;
                break;
            
            case 'G':
                myArr[2]++;
                if(myArr[2] == checkArr[2])
                    checkSeceret++;
                break;
            
            case 'T':
                myArr[3]++;
                if(myArr[3] == checkArr[3])
                    checkSeceret++;
                break;
        }
    }

    private static void Remove(char c){
        switch(c){
            case 'A':
                if(myArr[0] == checkArr[0])
                    checkSeceret--;
                myArr[0]--;
                break;
            case 'C':
                if(myArr[1] == checkArr[1])
                    checkSeceret--;
                myArr[1]--;
                break;
            case 'G':
                if(myArr[2] == checkArr[2])
                    checkSeceret--;
                myArr[2]--;
                break;
            case 'T':
                if(myArr[3] == checkArr[3])
                    checkSeceret--;
                myArr[3]--;
                break;
        }
    }
}
