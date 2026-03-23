import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken()); // 문서의 개수
            int M = Integer.parseInt(st.nextToken()); // 인덱스
            
            // int[] {초기 위치(인덱스), 중요도} 형태로 저장하여 문서를 식별
            LinkedList<int[]> que = new LinkedList<>();

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                // i: 초기 위치, Integer.parseInt: 문서의 중요도
                que.offer(new int[]{i, Integer.parseInt(st.nextToken())});
            }

            int count = 0; // 인쇄 횟수를 카운트할 변수
            
            while (!que.isEmpty()) {
                // 큐의 가장 앞에 있는 문서를 꺼냄
                int[] front = que.poll();

                // 현재 꺼낸 문서가 가장 중요도가 높은 문서인지 가정
                boolean isMax = true;
                
                for (int i = 0; i < que.size(); i++) {
                    if(front[1] < que.get(i)[1]) {

                        // 1. 방금 꺼냈던 문서를 다시 큐의 맨 뒤로 보낸다
                        que.offer(front);

                        // 2. 더 중요한 문서(인덱스 i)의 앞에 있던 문서들도 전부 뽑아서 순서대로 맨 뒤로 보낸다
                        for (int j = 0; j < i; j++) {
                            que.offer(que.poll());
                        }

                        // 가장 중요한 문서가 아니었으므로 false로 표시하고 비교를 멈춤
                        isMax = false;
                        break;
                    }
                }
                
                if (isMax == false) {
                    continue;
                }

                // 여기로 넘어왔다는 것은 현재 문서가 가장 중요하다는 뜻이므로 '인쇄'
                count++; 

                // 방금 인쇄한 문서의 초기 위치(front[0])가 우리가 찾던 그 문서인 경우
                if (front[0] == M) {
                    break; // 원하는 문서를 찾았으니 큐 탐색을 완전히 종료.
                }
            }
            sb.append(count).append('\n');
        }
        System.out.println(sb);
    }
}