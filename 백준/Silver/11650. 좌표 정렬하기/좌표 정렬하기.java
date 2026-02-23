import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][2];
        StringTokenizer st;

        // 좌표 입력받기
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        // 람다식을 이용한 정렬
        Arrays.sort(arr, (e1, e2) ->{
            // x 좌표가 같은 경우 y 좌표 기준 오름차순 정렬
            if(e1[0] == e2[0]){
                return e1[1] - e2[1];
            }else{      // x 좌표 기준 오름차순 정렬
                return e1[0] - e2[0];
            }
        });

        for (int i = 0; i < N; i++) {
            System.out.println(arr[i][0] + " " + arr[i][1]);
        }
        br.close();
    }
}