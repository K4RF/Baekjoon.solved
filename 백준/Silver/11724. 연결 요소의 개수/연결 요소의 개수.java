import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    // 2차원 배열 대신 ArrayList 배열 사용
    static ArrayList<Integer>[] adj;
    static boolean[] visit;
    static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        adj = new ArrayList[N + 1];
        visit = new boolean[N + 1];

        // 각 정점마다 리스트 초기화
        for (int i = 1; i <= N; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            // 양방향 연결을 리스트에 추가 (연결된 노드만 저장)
            adj[u].add(v);
            adj[v].add(u);
        }

        for (int i = 1; i <= N; i++) {
            if (!visit[i]) {
                dfs(i);
                result++;
            }
        }

        System.out.println(result);
        br.close();
    }

    public static void dfs(int node) {
        visit[node] = true;

        // 현재 노드에 연결된 노드들만 순회
        for (int next : adj[node]) {
            if (!visit[next]) {
                dfs(next);
            }
        }
    }
}