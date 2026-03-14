import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());

        int[] origin = new int[N];  // 입력받은 순서대로 저장할 원본 배열
        int[] sorted = new int[N];  // 크기 순으로 정렬하기 위해 복사해 둘 배열
        
        // 중복된 값을 한 번만 처리하고 빠른 검색(O(1))을 하기 위해 사용
        HashMap<Integer, Integer> rankingMap = new HashMap<Integer, Integer>();

        // 두 번째 줄의 입력: 공백으로 구분된 N개의 좌표 값들
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < N; i++) {
            // 원본 배열과 정렬용 배열에 동시에 값을 채움
            sorted[i] = origin[i] = Integer.parseInt(st.nextToken());
        }

        // 배열을 오름차순으로 정렬
        Arrays.sort(sorted);
        
        int rank = 0;

        // 정렬된 배열을 순회하면서 순위 매김
        for(int v : sorted) {
            if(!rankingMap.containsKey(v)) {
                // 현재 순위를 부여하고 Map에 저장
                rankingMap.put(v, rank);
                rank++;
            }
        }
        
        StringBuilder sb = new StringBuilder();
        
        for(int key : origin) {
            int ranking = rankingMap.get(key);
            // StringBuilder에 "순위 " 형태로 이어 붙임
            sb.append(ranking).append(' ');
        }
        System.out.println(sb);
    }
}