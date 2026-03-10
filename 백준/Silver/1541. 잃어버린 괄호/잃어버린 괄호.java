import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 최종 결과를 저장할 변수.
        // 초기값이 0이면 첫 번째 수가 음수인지 양수인지 구분하기 어렵기 때문에 MAX_VALUE로 초기값 설정
        int sum = Integer.MAX_VALUE;

        // 1. '-' 기호를 기준으로 문자열을 분리한다.
        StringTokenizer minus = new StringTokenizer(br.readLine(), "-");

        while(minus.hasMoreTokens()) {
            int temp = 0;

            // 2. '-'로 나뉜 각 토큰 내부에 있는 '+' 기호들을 처리한다.
            StringTokenizer plus = new StringTokenizer(minus.nextToken(), "+");

            // 3. '+'로 연결된 숫자들을 모두 더해 하나의 묶음(temp)으로 만든다.
            while(plus.hasMoreTokens()) {
                temp += Integer.parseInt(plus.nextToken());
            }

            // 4. 만약 sum이 초기 상태라면, 첫 번째 묶음이므로 결과 변수에 그대로 저장한다.
            if (sum == Integer.MAX_VALUE) {
                sum = temp;
            }
            
            // 5. 그 이후의 묶음들은 모두 뺄셈 처리하여 최솟값을 만든다.
            else {
                sum -= temp;
            }
        }
        
        System.out.println(sum);
        br.close();
    }
}