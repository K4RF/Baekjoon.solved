import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        Stack<Integer> stack = new Stack<Integer>();
        int K = Integer.parseInt(br.readLine());
        
        for (int i = 0; i < K; i++) {
            int num = Integer.parseInt(br.readLine());

            // 0이 입력된 경우
            if (num == 0) {
                // "가장 최근에 쓴 수를 지운다"는 규칙에 따라 스택의 맨 위(가장 최근) 값(삭제).
                stack.pop();
            } else {
                // 0이 아닌 일반 숫자라면 스택에 추가
                stack.push(num);
            }
        }
        
        int result = 0;

        // 스택이 완전히 빌 때까지(isEmpty()가 true가 될 때까지) 반복
        while (!stack.isEmpty()) {
            result += stack.pop();
        }
        
        System.out.println(result);
    }
}