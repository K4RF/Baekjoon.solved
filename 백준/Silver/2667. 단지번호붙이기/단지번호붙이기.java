import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Main {
    static int N;
    static int count; // 한 단지 내에 있는 집의 수
    static int[][] map;
    static boolean[][] visited;

    // 각 단지의 집 개수를 모아둘 리스트
    static List<Integer> result;

    // 방향 배열 (상, 하, 좌, 우 탐색용)
    static int[] dx = {-1, 1, 0, 0};    // 행의 변화량
    static int[] dy = {0, 0, -1, 1};    // 열의 변화량

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        result = new LinkedList<>();
        N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        visited = new boolean[N][N];
        
        for (int i = 0; i < N; i++) {
            String house = br.readLine();
            for (int j = 0; j < N; j++) {
                // 문자를 숫자로 변환해서 2차원 배열에 저장
                map[i][j] = house.charAt(j) - '0';
            }
        }
        
        for (int x = 0; x < N; x++) {
            for (int y = 0; y < N; y++) {
                // 집이 있고, 아직 다른 단지에 소속되지 않은 집
                if (map[x][y] == 1 && !visited[x][y]) {
                    // 현재 집을 포함하므로 count를 1로 시작
                    count = 1;
                    
                    dfs(x, y);
                    
                    // 완성된 단지의 크기를 리스트에 저장
                    result.add(count);
                }
            }
        }
        
        // 단지 내 집의 수를 오름차순으로 정렬
        Collections.sort(result);
        
        System.out.println(result.size());
        
        for (int r : result) {
            System.out.println(r);
        }
    }

    public static void dfs(int x, int y) {
        // 현재 집 방문 처리
        visited[x][y] = true;

        // 상하좌우 탐색
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i]; 
            int ny = y + dy[i];
            
            if (nx >= 0 && ny >= 0 && nx < N && ny < N) {
                // 다음 칸에 집이 있고 아직 방문하지 않았다면
                if (map[nx][ny] == 1 && !visited[nx][ny]) {
                    // 같은 단지로 처리 집 개수를 1개 늘림
                    count++;
                    // 다시 상하좌우 탐색 (재귀)
                    dfs(nx, ny);
                }
            }
        }
    }
}