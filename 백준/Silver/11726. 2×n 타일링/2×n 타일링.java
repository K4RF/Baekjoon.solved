import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] dp = new int[n + 1];

        // 기저 사례
        dp[0] = 1;
        dp[1] = 1;

        // Bottom-Up 방식으로 배열 채우기
        for (int i = 2; i <= n; i++) {
            // 오버플로우 방지를 위해 더할 때마다 10007로 나눈 나머지를 저장
            dp[i] = (dp[i - 1] + dp[i - 2]) % 10007;
        }

        System.out.println(dp[n]);
    }
}