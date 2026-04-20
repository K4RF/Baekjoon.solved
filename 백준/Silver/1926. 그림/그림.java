import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[][] graph;
    static boolean[][] visited;

    // 방향 배열 
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int num = 0;      // 그림의 개수
        int maxArea = 0;  // 가장 넓은 그림의 넓이

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (graph[i][j] == 1 && !visited[i][j]) {
                    num++; // 새로운 그림 발견
                    maxArea = Math.max(maxArea, bfs(i, j));
                }
            }
        }
        System.out.println(num);
        System.out.println(maxArea);
    }
    
    public static int bfs(int x, int y) {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{x, y});
        // 현재 위치 방문처리
        visited[x][y] = true;

        int area = 0; // 현재 그림의 넓이를 카운트할 지역 변수

        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            area++; // 큐에서 하나 뽑을 때마다 넓이 1 증가

            for (int i = 0; i < 4; i++) {
                int nextX = now[0] + dx[i];
                int nextY = now[1] + dy[i];

                // 맵 범위를 벗어나지 않는지 확인
                if (nextX >= 0 && nextY >= 0 && nextX < N && nextY < M) {
                    // 방문하지 않았고, 그림(1)인 경우에만 큐에 추가
                    if (!visited[nextX][nextY] && graph[nextX][nextY] == 1) {
                        queue.offer(new int[]{nextX, nextY});
                        visited[nextX][nextY] = true; // 큐에 넣을 때 바로 방문 처리
                    }
                }
            }
        }
        return area; // 최종 계산된 그림의 넓이 반환
    }
}