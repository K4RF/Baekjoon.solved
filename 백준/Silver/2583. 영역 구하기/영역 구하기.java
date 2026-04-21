import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M, K;
    static int[][] graph;
    static boolean[][] visited;

    // 방향 배열 (상, 하, 좌, 우)
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 빈 영역의 넓이들을 담을 리스트
        ArrayList<Integer> list = new ArrayList<>();

        M = Integer.parseInt(st.nextToken()); // 행(y)
        N = Integer.parseInt(st.nextToken()); // 열(x)
        K = Integer.parseInt(st.nextToken()); // 직사각형 개수

        graph = new int[M][N];
        visited = new boolean[M][N];
        
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            
            // 시작점
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            
            // 끝점
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            
            for (int y = y1; y < y2; y++) {
                for (int x = x1; x < x2; x++) {
                    graph[y][x] = 1;
                }
            }
        }

        int count = 0; // 분리된 영역의 개수
        
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (graph[i][j] == 0 && !visited[i][j]) {
                    list.add(bfs(i, j));
                    count++; // 영역 개수 증가
                }
            }
        }

        // 문제 조건에 맞게 넓이를 오름차순 정렬
        Collections.sort(list);

        // StringBuilder를 사용해 정답 세팅
        StringBuilder sb = new StringBuilder();
        sb.append(count).append("\n"); // 첫 줄에 영역 개수

        for (int size : list) {
            sb.append(size).append(" "); // 다음 줄에 넓이들 쭉 이어 붙임
        }

        System.out.println(sb);
    }
    
    public static int bfs(int x, int y) {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{x, y});

        // 현재 위치 방문 처리
        visited[x][y] = true;
        
        // 넓이 초기화
        int size = 1;

        while (!queue.isEmpty()) {
            int[] now = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nextX = now[0] + dx[i]; // 다음 행
                int nextY = now[1] + dy[i]; // 다음 열

                // 맵 범위를 벗어나지 않는지 확인
                if (nextX >= 0 && nextY >= 0 && nextX < M && nextY < N) {
                    // 방문하지 않았고, 빈 공간인 경우
                    if (!visited[nextX][nextY] && graph[nextX][nextY] == 0) {
                        queue.offer(new int[]{nextX, nextY});
                        visited[nextX][nextY] = true; // 큐에 넣을 때 바로 방문 처리

                        size++; // 새로운 빈 공간을 찾았을 때만 넓이 증가
                    }
                }
            }
        }
        return size;
    }
}