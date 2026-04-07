import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int node = Integer.parseInt(st.nextToken());
        int line = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());

        // 그래프 생성
        for (int i = 0; i <= node; i++) {
            graph.add(new ArrayList<>());
        }

        // 양방향 간선 연결
        for (int i = 0; i < line; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        // 작은 번호부터 방문하므로 리스트 정렬
        for (int i = 0; i <= node; i++) {
            Collections.sort(graph.get(i));
        }

        // dfs 방문 배열
        visited = new boolean[node + 1];
        dfs(V);
        
        // 맨 뒤의 공백 제거
        sb.deleteCharAt(sb.length() - 1);
        sb.append("\n");

        // bfs 방문 배열
        visited = new boolean[node + 1];
        bfs(V);

        System.out.println(sb);

    }
    static void dfs(int V) {
        // 현재 노드 방문 처리
        visited[V] = true;
        sb.append(V).append(" ");

        // 현재 노드와 연결된 다음 노드 탐색(재귀)
        for (int next : graph.get(V)) {
            if (!visited[next]) {   // 다음 노드가 방문을 안한 경우에만 재귀
                dfs(next);
            }
        }       
    }

    static void bfs(int V) {
        Queue<Integer> queue = new LinkedList<>();

        // 시작 노드를 큐에 넣고 방문처리
        queue.offer(V);
        visited[V] = true;

        // 큐가 빌 때까지 반복
        while (!queue.isEmpty()) {
            // 큐에서 노드를 하나 꺼내서 출력 버퍼에 저장
            int node = queue.poll();
            sb.append(node).append(" ");

            // 꺼낸 노드와 연결된 인접 노드 확인
            for (int next : graph.get(node)) {
                if (!visited[next]) {   // 아직 방문하지 않은 노드인 경우에만 큐에 넣고 방문처리
                    visited[next] = true;
                    queue.offer(next);
                }
            }
        }
        // 맨 뒤의 공백 제거
        sb.deleteCharAt(sb.length() - 1);
    }
}
