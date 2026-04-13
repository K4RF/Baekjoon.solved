import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static boolean[] visit;
    static int result = 0;

    @SuppressWarnings("unchecked")
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        visit = new boolean[N + 1];

        // 그래프 생성
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            // 양방향 연결을 리스트에 추가 (연결된 노드만 저장)
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        for (int i = 1; i <= N; i++) {
            if (!visit[i]) {
                bfs(i);
                result++;
            }
        }

        System.out.println(result);
        br.close();
    }

    static void bfs(int V) {
        Queue<Integer> queue = new LinkedList<>();

        // 시작 노드를 큐에 넣고 방문처리
        queue.offer(V);
        visit[V] = true;

        // 큐가 빌 때까지 반복
        while (!queue.isEmpty()) {
            // 큐에서 노드를 하나 꺼내서 출력 버퍼에 저장
            int node = queue.poll();

            // 꺼낸 노드와 연결된 인접 노드 확인
            for (int next : graph.get(node)) {
                if (!visit[next]) {   // 아직 방문하지 않은 노드인 경우에만 큐에 넣고 방문처리
                    visit[next] = true;
                    queue.offer(next);
                }
            }
        }
    }
}