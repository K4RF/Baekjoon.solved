import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 회의의 개수

        // 2차원 배열 생성 (0: 시작시간, 1: 종료시간)
        int[][] timeTable = new int[N][2];
        StringTokenizer st;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            timeTable[i][0] = Integer.parseInt(st.nextToken()); // 시작 시간 저장
            timeTable[i][1] = Integer.parseInt(st.nextToken()); // 종료 시간 저장
        }

        // 핵심: 그리디 알고리즘을 위한 정렬 (Custom Comparator)
        Arrays.sort(timeTable, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                // 1. 종료시간이 같다면 시작시간이 빠른 순으로 정렬
                if(o1[1] == o2[1]){
                    return o1[0] - o2[0];
                }
                // 2. 기본적으로는 종료시간이 빠른 순(오름차순)으로 정렬
                return o1[1] - o2[1];
            }
        });

        int count = 0;           // 배정된 회의 개수
        int prev_end_time = 0;   // 직전 회의가 끝난 시간

        for (int i = 0; i < N; i++) {
            // 현재 회의의 시작 시간이 직전 회의 종료 시간보다 크거나 같다면 배정
            if (timeTable[i][0] >= prev_end_time) {
                prev_end_time = timeTable[i][1]; // 종료 시간 갱신
                count++; // 회의 개수 증가
            }
        }

        System.out.println(count); 
        br.close();
    }
}