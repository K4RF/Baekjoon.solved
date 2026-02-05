import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());        // 입력받을 데이터의 수

        for (int i = 0; i < T; i++) {
            String str = br.readLine();        // 괄호 문자열
            Stack<Character> stack = new Stack<>();     // 빈 스택 생성

            for (int j = 0; j < str.length(); j++) {
                if (str.charAt(j) == '(') {
                    stack.push(str.charAt(j));
                } else {
                    if (stack.isEmpty()) {  // 비어있는지 확인
                        stack.push(str.charAt(j));
                        break;      // ')'인데 스택이 비어있으면 맞는 짝이 없으므로 멈춤
                    } else {
                        stack.pop();    // vps 한쌍 제거
                    }
                }
            }
            if (stack.isEmpty()) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}
