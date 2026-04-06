import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static Integer[][] dp = new Integer[41][2];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine());

        // N이 0일 때
        dp[0][0] = 1;
        dp[0][1] = 0;
        // N이 1일 때
        dp[1][0] = 0;
        dp[1][1] = 1;

        while (K-- > 0) {
            int N = Integer.parseInt(br.readLine());
            fibonacci(N);
            System.out.println(dp[N][0] + " " + dp[N][1]);
        }
    }

    // Top-Down 방식의 DP 메서드
    static Integer[] fibonacci(int N) {
        // 아직 계산된 적 없는 N인 경우에만 계산 수행
        if (dp[N][0] == null || dp[N][1] == null) {
            // N의 0 호출 횟수: (N-1)의 0 호출 횟수 + (N-2)의 0 호출 횟수
            dp[N][0] = fibonacci(N - 1)[0] + fibonacci(N - 2)[0];

            // N의 1 호출 횟수: (N-1)의 1 호출 횟수 + (N-2)의 1 호출 횟수
            dp[N][1] = fibonacci(N - 1)[1] + fibonacci(N - 2)[1];
        }
        return dp[N];
    }
}
