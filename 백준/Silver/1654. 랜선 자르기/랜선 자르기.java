import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int[] arr = new int[K];

        long max = 0;

        for (int i = 0; i < K; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            if (max < arr[i]) {
                max = arr[i];
            }
        }
        
        // 배열의 인덱스처럼 Upper Bound 범위를 맞추기 위해 max에 1을 더해줌
        max++;
        long min = 0;
        long mid = 0;
        

        while (min < max) {
            // 중간값
            mid = (max + min) / 2;

            long count = 0; // 만들어진 랜선의 총 개수

            // 가지고 있는 랜선들을 mid 길이로 잘라서 몇 개가 나오는지 구함
            for (int i = 0; i < arr.length; i++) {
                count += (arr[i] / mid);
            }

            //자른 개수가 필요한 개수보다 적은 경우 자르는 길이를 줄임
            if (count < N) {
                max = mid;
            }
            // 자른 개수가 필요한 개수보다 많거나 같은 경우 자르는 길이를 늘림
            else {
                min = mid + 1; 
            }
        }
        
        System.out.println(min - 1);
    }
}