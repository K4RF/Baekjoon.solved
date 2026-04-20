import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int w, h;
    static int nextX, nextY;
    static int[][] arr;
    static boolean[][] visit;

    // 상하좌우 및 대각선 8방향 탐색 배열
    static int[] dx = {0, 0, -1, 1, -1, 1, -1, 1};
    static int[] dy = {-1, 1, 0, 0, -1, -1, 1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        String str = " ";

        // "0 0"이 입력될 때까지 테스트 케이스 반복
        while (!(str = br.readLine()).equals("0 0")) {
            st = new StringTokenizer(str);

            w = Integer.parseInt(st.nextToken()); // 열(너비)
            h = Integer.parseInt(st.nextToken()); // 행(높이)

            arr = new int[h][w];
            visit = new boolean[h][w];

            // 지도 데이터 입력 (1: 땅, 0: 바다)
            for (int i = 0; i < h; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < w; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int count = 0; // 섬의 개수

            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    if (!visit[i][j] && arr[i][j] == 1) {
                        dfs(i, j);
                        count++;
                    }
                }
            }
            sb.append(count).append("\n");
        }
        System.out.println(sb);
    }

    static void dfs(int x, int y) {
        // 현재 좌표 방문 처리
        visit[x][y] = true;

        // 8방향 탐색 진행
        for (int i = 0; i < 8; i++) {
            nextX = dx[i] + x;
            nextY = dy[i] + y;

            // 지도 범위를 벗어나지 않는지 확인
            if (nextX >= 0 && nextY >= 0 && nextX < h && nextY < w) {
                // 다음 위치가 땅(1)이고 방문하지 않은 경우 재귀 호출
                if (!visit[nextX][nextY] && arr[nextX][nextY] == 1) {
                    dfs(nextX, nextY);
                }
            }
        }
    }
}