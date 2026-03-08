import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static int [] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 이진 탐색을 위해 배열 정렬
        Arrays.sort(arr);

        int M = Integer.parseInt(br.readLine());

        st= new StringTokenizer(br.readLine(), " ");
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < M; i++){
            if(binarySearch(Integer.parseInt(st.nextToken())) >= 0){
                sb.append(1).append('\n');
            }else{
                sb.append(0).append('\n');
            }
        }
        System.out.println(sb);
        br.close();
    }

    public static int binarySearch(int key) {
        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            // 중간 위치 찾기
            int mid = (low + high) / 2;

            // 키 값이 중간 위치보다 작은 경우
            if (key < arr[mid]) {
                high = mid - 1;
            }
            // 키 값이 중간 위치보다 큰 경우
            else if (key > arr[mid]) {
                low = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}
