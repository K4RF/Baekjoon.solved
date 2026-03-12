import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    // 방문 여부를 체크하여 중복 탐색을 막기 위한 배열
    static boolean[] visited;
    // N: 수빈이의 위치 (출발지), K: 동생의 위치 (목적지)
    static int N, K;
    // 최소 시간을 저장할 변수
    static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        
        // 배열의 인덱스를 100,000까지 사용하기 위해 크기를 100,001로 설정
        visited = new boolean[100001];

        // BFS 알고리즘 실행
        bfs(N, K);
        
        System.out.println(result);
    }

    public static void bfs(int start, int target) {
        // 큐에는 {현재 위치, 걸린 시간} 형태의 배열이 들어갑니다.
        Queue<int[]> que = new LinkedList<>();

        // 시작 위치 방문 처리
        visited[start] = true;
        // 큐에 시작 위치와 초기 시간(0초) 기입
        que.offer(new int[]{start, 0});

        while (!que.isEmpty()) {
            // 큐에서 현재 상태(현재 위치, 시간)
            int[] cur = que.poll();
            int pos = cur[0];  // 현재 위치
            int time = cur[1]; // 현재까지 걸린 시간

            // 목적지(동생의 위치)에 도달했다면
            if (pos == target) {
                result = time; // 결과를 저장하고
                break;         // 탐색을 종료
            }

            // 현재 위치에서 이동할 수 있는 3가지 경우의 수 (앞으로 한 칸, 뒤로 한 칸, 순간이동)
            int[] direction = {pos + 1, pos - 1, pos * 2};

            // 3가지 이동 경우의 수를 하나씩 확인
            for (int d : direction) {
                // d(다음 위치)가 유효한 범위내에 있고, 아직 방문하지 않은 곳이라면
                if(d >= 0 && d < 100001 && !visited[d]){
                    visited[d] = true; // 방문 처리
                    que.offer(new int[]{d, time + 1}); // 큐에 다음 위치와 시간(현재 시간 + 1초) 기입
                }
            }
        }
    }
}