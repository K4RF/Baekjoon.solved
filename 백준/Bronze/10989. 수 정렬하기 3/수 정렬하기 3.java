import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        // 숫자 카운팅 배열 범위(0 ~ 10000) 자연수이므로 0 제외
        int[] count = new int[10001];

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            // 입력받은 숫자의 인데스 값의 카운팅 증가
            count[Integer.parseInt(br.readLine())]++;
        }
        
        StringBuilder sb = new StringBuilder();
        
        // N값이 자연수 이므로 0은 제외
        for (int i = 1; i < count.length; i++) {
            // i 값의 개수가 0이 될 때까지 출력
            while (count[i] > 0) {
                sb.append(i).append('\n');
                count[i]--;
            }
        }
        System.out.println(sb);
        br.close();
    }
}
