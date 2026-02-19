import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    private static int lowerBound(int[] arr, int key) {
        int low = 0;
        int high = arr.length;

        // low와 high 값이 같아질 때까지 반복
        while (low < high) {
            int mid = (low + high) / 2;    // 중간 위치[이진탐색]

            if (key <= arr[mid]) {  // 정렬된 배열에서 key 값이 배열 중간 위치값보다 작은경우 중간값을 high로 설정, 중복 원소에 대해 왼쪽으로 탐색
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    private static int upperBound(int[] arr, int key) {
        int low = 0;
        int high = arr.length;

        while (low < high) {
            int mid = (low + high) / 2;    // 중간 위치[이진탐색]

            if (key < arr[mid]) {  // 정렬된 배열에서 key 값이 배열 중간 위치값보다 작은경우
                high = mid;
            } else {    // 중복 원소의 경우
                low = mid + 1;
            }
        }
        return low;
    }
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        int M = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine()," ");
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < M; i++) {
            int key = Integer.parseInt(st.nextToken());

            sb.append(upperBound(arr, key) - lowerBound(arr, key)).append(' ');
        }
        System.out.println(sb);
    }
}
