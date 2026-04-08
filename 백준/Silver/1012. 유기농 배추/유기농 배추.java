import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int M, N, K;
    static int count; // 필요한 지렁이 마리 수
    static int[][] field; // 배추밭 배열
    static boolean[][] visited; // 방문 체크 배열

    // 방향 배열 (상, 하, 좌, 우 탐색용)
    static int[] dr = {-1, 1, 0, 0};    // 행의 변화량
    static int[] dc = {0, 0, -1, 1};    // 열의 변화량

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder(); 

        int T = Integer.parseInt(br.readLine()); 

        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken()); // 가로 길이 
            N = Integer.parseInt(st.nextToken()); // 세로 길이 
            K = Integer.parseInt(st.nextToken()); // 심어진 배추의 개수

            // 테스트 케이스마다 새로운 배추밭과 방문 배열로 초기화
            field = new int[N][M];
            visited = new boolean[N][M];

            // 배추 심기
            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());
                int X = Integer.parseInt(st.nextToken()); 
                int Y = Integer.parseInt(st.nextToken()); 
                
                field[Y][X] = 1;
            }

            count = 0; 

            // 밭 전체를 [0][0]부터 끝까지 하나씩 확인
            for (int i = 0; i < N; i++) {       // 
                for (int j = 0; j < M; j++) {   // 
                    // 배추가 심어져 있고(1), 아직 방문하지 않은 경우에
                    if (field[i][j] == 1 && !visited[i][j]) {
                        count++;   
                        dfs(i, j); // 해당 위치부터 연결된 배추들을 전부 방문 처리(재귀)
                    }
                }
            }
            sb.append(count).append('\n');
        }
        System.out.println(sb);
    }


    public static void dfs(int x, int y) {
        // 현재 배추 방문처리
        visited[x][y] = true;

        // 0부터 3까지 4번 반복하며 상하좌우 탐색
        for (int i = 0; i < 4; i++) {
            int nr = x + dr[i]; // nr: next_row (다음 행 좌표)
            int nc = y + dc[i]; // nc: next_colum (다음 열 좌표)

            // 다음 좌표가 배추밭 범위를 벗어나지 않았는지 먼저 체크하여 에러 방지
            if (nr >= 0 && nc >= 0 && nr < N && nc < M) {
                // 해당 위치에 배추가 있고 아직 방문처리 되지 않은 경우
                if (field[nr][nc] == 1 && !visited[nr][nc]) {
                    dfs(nr, nc);
                }
            }
        }
    }
}