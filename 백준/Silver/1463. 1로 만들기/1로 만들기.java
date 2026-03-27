import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    // 계산된 결과값을 저장할 메모이제이션 배열
    static Integer[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        
        dp = new Integer[N + 1];

        // 0과 1은 연산 횟수가 0이므로 기저 사례로 설정
        dp[0] = dp[1] = 0;

        System.out.println(recur(N));
    }

    static int recur(int N) {
        // 아직 계산되지 않은 값인 경우에만 계산 수행
        if (dp[N] == null) {

            // 6으로 나누어지는 경우: 3으로 나누기, 2로 나누기, 1 빼기 중 최솟값 탐색
            if (N % 6 == 0) {
                // 각 연산 후 횟수(+1)를 더해줌
                dp[N] = Math.min(recur(N / 3), Math.min(recur(N / 2), recur(N - 1))) + 1;
            }
            else if (N % 3 == 0) {
                dp[N] = Math.min(recur(N / 3), recur(N - 1)) + 1;
            }
            else if (N % 2 == 0) {
                dp[N] = Math.min(recur(N / 2), recur(N - 1)) + 1;
            }
            // 어떤 수로도 나누어지지 않는 경우: 1을 빼는 연산 수행
            else {
                dp[N] = recur(N - 1) + 1;
            }
        }
        // 계산되어 있는 값을 반환
        return dp[N];
    }
}