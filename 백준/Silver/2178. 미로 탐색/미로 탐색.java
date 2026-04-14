import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[][] maze;
    static boolean[][] visited;

    // 방향 배열 (상, 하, 좌, 우)
    static int[] dx = { -1, 1, 0, 0 };
    static int[] dy = { 0, 0, -1, 1 }; 

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        maze = new int[N][M];
        
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                // 문자를 숫자로 변환하여 미로 지도 생성 (1: 이동 가능, 0: 벽)
                maze[i][j] = line.charAt(j) - '0';
            }
        }

        visited = new boolean[N][M]; // 방문 여부를 체크할 배열
        visited[0][0] = true;        // 시작점 방문 처리

        // (0, 0)에서부터 BFS 탐색 시작
        bfs(0, 0);
        
        System.out.println(maze[N-1][M-1]);
    }
    
    static void bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y}); // 시작 좌표를 큐에 넣음
        
        while (!queue.isEmpty()) {
            int now[] = queue.poll(); // 현재 서 있는 위치를 큐에서 꺼냄
            int nX = now[0];      // 현재 위치의 행(x)
            int nY = now[1];      // 현재 위치의 열(y)

            // 상하좌우 4방향을 모두 탐색
            for (int i = 0; i < 4; i++) {
                int nextX = nX + dx[i]; // 이동할 다음 행
                int nextY = nY + dy[i]; // 이동할 다음 열

                // 미로 범위를 벗어나면 패스
                if (nextX < 0 || nextY < 0 || nextX >= N || nextY >= M) {
                    continue;
                }

                // 이미 방문한 곳이거나, 벽이라서 갈 수 없는 곳이면 패스
                if (visited[nextX][nextY] || maze[nextX][nextY] == 0) {
                    continue;
                }
                

                // 다음 방문을 위해 큐에 넣음
                queue.add(new int[]{nextX, nextY});

                // 이전 위치까지의 거리 + 1을 다음 위치에 기록함. 목적지에 적힌 숫자가 최소 이동 칸 수가 됨
                maze[nextX][nextY] = maze[nX][nY] + 1;
                visited[nextX][nextY] = true;
            }
        }
    }
}