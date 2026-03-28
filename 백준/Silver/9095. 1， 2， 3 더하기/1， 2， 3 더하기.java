import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            int n = Integer.parseInt(br.readLine());

            // 문제 조건에서 n은 11보다 작으므로
            int[] dp = new int[11];
            
            // 기저사례
            dp[1] = 1;
            dp[2] = 2;
            dp[3] = 4;

            // 4부터 n까지 점화식을 적용하여 Bottom-Up 방식으로 배열 채움
            for (int i = 4; i <= n; i++) {
                // 점화식: 직전 3개의 결과값을 합산
                dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
            }

            bw.write(dp[n] + "\n");
        }

        bw.flush();
    }
}