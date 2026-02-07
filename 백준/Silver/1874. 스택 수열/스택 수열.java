import java.io.*;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        // 버퍼 입출력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        // 입력 횟수
        int N = Integer.parseInt(br.readLine());
        Stack<Integer> stack =new Stack<>();
        int last = 0;

        for(int i=0; i<N;i++){
            // 수 입력받음
            int n = Integer.parseInt(br.readLine());
            // 입력받은 수 검증(임시값보다 크면 스택 push)
            if(n>last){
                for(int j=last+1 ; j<=n; j++){
                    stack.push(j);
                    sb.append("+\n");
                }
                // 임시값을 입력받은 수로 저장
                last = n;
            }
            // 임시값이 해당 순서의 숫자보다 작은 경우
            if(stack.get(stack.size()-1)==n){
                stack.pop();
                sb.append("-\n");
            }
        }
        // 반복문 종료 후 스택에 요소가 하나 이상 남은 경우
        if(stack.size()>0){
            bw.write("NO\n");
        }
        else {
            bw.write(sb+"\n");
        }
        bw.flush();
        bw.close();
    }
}