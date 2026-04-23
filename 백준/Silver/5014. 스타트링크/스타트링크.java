import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int F, S, G;
    static int[] count;

    // 이동할 층수
    static int[] dir = new int[2];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        F = Integer.parseInt(st.nextToken()); // 총 층수
        S = Integer.parseInt(st.nextToken()); // 현재 위치
        G = Integer.parseInt(st.nextToken()); // 목표 위치

        dir[0] = Integer.parseInt(st.nextToken()); // 위로 U층
        dir[1] = -Integer.parseInt(st.nextToken()); // 아래로 D층

        // 층수는 1층부터 시작하므로 F + 1 크기로 할당
        count = new int[F + 1];
        bfs(S);
    }

    static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[F + 1]; // 방문 체크 배열

        queue.add(start);
        visited[start] = true;
        count[start] = 0; // 시작 위치의 버튼 클릭 수는 0

        while (!queue.isEmpty()) {
            int now = queue.poll();

            // 목표 층에 도달하면 해당 층의 클릭 수를 출력하고 즉시 종료
            if (now == G) {
                System.out.println(count[now]);
                return;
            }
            
            for (int i = 0; i < 2; i++) {
                int next = now + dir[i];

                // 건물 범위를 벗어나면 패스 (1층보다 낮거나 F층보다 높을 수 없음)
                if (next > F || next < 1) continue;
                
                if (!visited[next]) {
                    queue.add(next);
                    visited[next] = true;
                    // 이전 층까지의 클릭 수 + 1을 기록
                    count[next] = count[now] + 1;
                }
            }
        }
        // 엘리베이터로 이동 불가능한 경우
        System.out.println("use the stairs");
    }
}