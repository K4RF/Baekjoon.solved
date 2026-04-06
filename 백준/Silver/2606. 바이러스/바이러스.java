import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    // 2차원 리스트를 활용한 인접 리스트 형태의 그래프
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    // 방문 여부를 체크
    static boolean[] visited;
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 전체 컴퓨터의 수 (노드 개수)
        int N = Integer.parseInt(br.readLine());
        // 네트워크 상에서 직접 연결되어 있는 컴퓨터 쌍의 수
        int M = Integer.parseInt(br.readLine());

        visited = new boolean[N + 1];

        // 그래프 내부의 1차원 리스트들을 초기화
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        // 간선 정보 입력 및 양방향 그래프 구성
        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            // 네트워크 연결은 양방향이므로, 서로의 리스트에 상대방 번호를 추가
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        dfs(1);

        System.out.println(count);
    }

    static void dfs(int node) {
        // 현재 노드(컴퓨터) 방문 처리
        visited[node] = true;

        // 현재 컴퓨터와 직접 연결된 다른 컴퓨터들을 하나씩 확인
        for(int next:graph.get(node)) {
            if(!visited[next]) {
                count++;
                // 해당 컴퓨터로 넘어가서 다시 연결된 다른 컴퓨터들을 재귀호출하여 감염시킴
                dfs(next);
            }
        }
    }
}
