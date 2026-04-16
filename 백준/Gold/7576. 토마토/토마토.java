import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int M, N;
    static int[][] field; // 토마토 상자 배열

    // BFS 탐색을 위한 큐
    static Queue<int[]> que = new LinkedList<>();

    // 방향 배열
    static int[] dx = {-1, 1, 0, 0};    // 행의 변화량
    static int[] dy = {0, 0, -1, 1};    // 열의 변화량

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken()); // 열
        N = Integer.parseInt(st.nextToken()); // 행

        field = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                field[i][j] = Integer.parseInt(st.nextToken());
                if (field[i][j] == 1) {
                    que.add(new int[]{i, j});
                }
            }
        }

        System.out.println(bfs());
    }

    public static int bfs() {
        while (!que.isEmpty()) {
            int now[] = que.poll(); // 현재 서 있는 위치를 큐에서 꺼냄
            int x = now[0];      // 현재 위치의 행
            int y = now[1];      // 현재 위치의 열

            // 상하좌우 4방향을 모두 탐색
            for (int i = 0; i < 4; i++) {
                int nX = x + dx[i]; // 이동할 다음 행
                int nY = y + dy[i]; // 이동할 다음 열

                // 상자 범위를 벗어나지 않았는지 체크
                if (nX >= 0 && nY >= 0 && nX < N && nY < M) {
                    // 주변에 아직 익지 않은 토마토가 있다면
                    if (field[nX][nY] == 0) {
                        que.add(new int[]{nX, nY});
                        // 날짜를 세기 위해
                        field[nX][nY] = field[x][y] + 1;
                    }
                }
            }
        }
        return checkResult();
    }

    public static int checkResult() {
        int maxDays = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                // 익지 않은 토마토가 하나라도 발견되면 즉시 -1 반환
                if (field[i][j] == 0) {
                    return -1;
                }
                // 가장 오래 걸린 날짜 갱신
                maxDays = Math.max(maxDays, field[i][j]);
            }
        }

        // 저장될 때부터 모든 토마토가 익어있던 상태
        if (maxDays == 1) {
            return 0;
        } else {
            // 아닐 경우 최종 날짜 - 1
            return maxDays - 1;
        }
    }
}
