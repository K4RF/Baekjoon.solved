import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        
        // 입력되는 숫자의 범위가 -4000 ~ 4000이므로, 음수를 인덱스로 쓸 수 없기 때문에 +4000을 해서 0 ~ 8000의 인덱스를 가질 수 있도록
        int[] arr = new int[8001];

        int sum = 0; 
        int max = Integer.MIN_VALUE; 
        int min = Integer.MAX_VALUE; 

        int mid = 10000; // 중앙값
        int mode = 10000; // 최빈값

        // 1. 숫자 입력 및 기본 통계 데이터 수집
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());
            sum += num;

            // 숫자가 등장한 횟수를 배열의 인덱스에 기록 (카운팅)
            arr[num + 4000]++;

            // 입력받으면서 최댓값과 최솟값을 바로바로 갱신합니다.
            if (max < num) {
                max = num;
            }
            if (min > num) {
                min = num;
            }
        }

        int count = 0; 
        int mode_max = 0; // 최빈값을 찾기 위해, 가장 많이 등장한 횟수를 저장
        
        boolean flag = false;

        // 2. 카운팅 배열을 순회하며 중앙값과 최빈값 찾기
        for (int i = min + 4000; i <= max + 4000; i++) {
            // 해당 숫자가 한 번이라도 등장했다면
            if (arr[i] > 0) {
                
                // 중앙값: 누적된 숫자 개수(count)가 전체의 절반((N + 1) / 2)에 도달하지 않았다면
                if (count < (N + 1) / 2) {
                    count += arr[i]; // 개수를 누적
                    mid = i - 4000;  // 누적하다가 절반을 넘어가는 순간의 값이 중앙값
                }
                
                // 최빈값: 지금까지 기록된 최대 등장 횟수보다 현재 숫자의 등장 횟수가 더 많은 경우
                if (mode_max < arr[i]) {
                    mode_max = arr[i];   // 최대 등장 횟수 갱신
                    mode = i - 4000;     // 최빈값 갱신
                    flag = true; 

                    // 현재 숫자의 등장 횟수가 최대 등장 횟수와 같고, 스위치가 켜져 있는 경우 두 번째로 작은 최빈값이 된다
                } else if (mode_max == arr[i] && flag) {
                    mode = i - 4000;     
                    flag = false;      
                }
            }
        }
        
        System.out.println((int)Math.round((double)sum / N));       // 총합을 N으로 나눈 뒤 Math.round로 반올림
        System.out.println(mid);    // 중앙값
        System.out.println(mode);   // 최빈값
        System.out.println(max - min);  // 범위
    }
}