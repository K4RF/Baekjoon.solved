import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        // 회원 수 입력
        int N = Integer.parseInt(br.readLine());

        // 입력 순서를 유지하기 위해 List 사용
        // 각 요소는 [나이, 이름] 형태의 String 배열
        List<String[]> list = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            // 각 요소로 크기 2의 String 배열 추가
            list.add(new String[]{st.nextToken(), st.nextToken()});
        }

        // comparator 오버라이딩 - 나이 기준 오름차순 정렬
        list.sort((n1, n2)->{
            // 나이가 서로 다르면
            if(!n1[0].equals(n2[0])) {
                // 문자열을 정수로 변환 후 오름차순 정렬
                return Integer.parseInt(n1[0])- Integer.parseInt(n2[0]);
            }
            // 나이가 같으면 순서 유지 (입력 순서 유지)
            else {
                return 0;
            }
        });

        // 정렬된 결과 출력
        for(String[] l: list){
            sb.append(l[0]).append(' ').append(l[1]).append('\n');
        }
        System.out.println(sb);

        br.close();
    }
}
