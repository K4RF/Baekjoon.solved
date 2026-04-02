import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static Integer dp[];
    static int arr[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        dp = new Integer[N + 1];
        arr = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        // 기저 사례
        dp[0] = 0; // 시작점
        dp[1] = arr[1]; // 첫 번째 계단은 무조건 밟는 것이 최댓값
        
        if (N >= 2) {
            dp[2] = arr[1] + arr[2];
        }

        System.out.println(findMax(N));
    }

    // Top-Down 방식의 DP 메서드
    static int findMax(int N) {
        // 한 번도 계산한 적 없는 계단인 경우에만 로직 수행
        if (dp[N] == null) {
            /**
             * 1. N-2 계단을 밟고 N 계단으로 올라온 경우: findMax(N - 2)
             * 2. N-1 계단을 밟고 N 계단으로 올라온 경우: 3연속을 피하기 위해 N-2는 무조건 밟지 않아야 함.
             */
            dp[N] = Math.max(findMax(N - 2), findMax(N - 3) + arr[N - 1]) + arr[N];
        }
        
        return dp[N];
    }
}