import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] tree = new int[N];

        int min = 0;
        int max = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            tree[i] = Integer.parseInt(st.nextToken());

            // 입력받은 나무 중 가장 높은 나무의 높이를 max로 설정
            if (max < tree[i]) {
                max = tree[i];
            }
        }


        // 매개 변수 탐색: min과 max가 같아질 때까지 반복
        while (min < max) {
            // 이번 턴에 톱날을 설정할 높이 (중간값)
            int mid = (min + max) / 2;

            /**
             * 잘려나간 나무 길이의 합.
             * N은 최대 100만, 각 나무 높이는 최대 10억이므로 합은 int 범위를 초과하여 long 타입으로 선언
              */
            long sum = 0;

            // 모든 나무를 순회하면서 mid 높이로 잘랐을 때 얻을 수 있는 나무의 양을 계산
            for (int height : tree) {
                // 톱날(중간값)보다 나무가 더 높아야만 잘려나간 부분이 생김
                if (height - mid > 0) {
                    sum += height - mid;
                }
            }

            //  잘라낸 나무의 총합이 필요한 양보다 적은 경우 -> 톱날의 높이를 낮춤
            if (sum < M) {
                max = mid; 
            }
            // 잘라낸 나무의 총합(sum)이 필요한 양(M)보다 많거나 같은 경우 -> 톱날을 조금 더 올려도 M만큼 얻을 수 있는지 확인
            else {
                min = mid + 1; 
            }
        }
        System.out.println(min - 1);
    }
}