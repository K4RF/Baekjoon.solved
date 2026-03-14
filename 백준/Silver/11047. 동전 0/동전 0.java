import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");


        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        // 각 동전의 가치를 저장할 배열
        int[] coin = new int[N];
        
        for (int i = 0; i < N; i++) {
            coin[i] = Integer.parseInt(br.readLine());
        }
        
        int count = 0;
        
        /**
         * 그리디 알고리즘
         * 가장 가치가 큰 동전부터 확인하기 위해 배열의 맨 뒤(N-1)부터 거꾸로 순회
         */
        for (int i = N - 1; i >= 0; i--) {
            if (coin[i] <= K) {
                // K를 현재 동전 가치로 나눈 몫 = 사용할 수 있는 해당 동전의 최대 개수
                count += K / coin[i];
                // 해당 동전으로 계산하고 남은 목표 금액
                K %= coin[i];
            }
        }

        System.out.println(count);
    }
}