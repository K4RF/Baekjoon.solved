import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // 듣도 못한 사람 리스트
        HashSet<String> list = new HashSet<>();
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            list.add(s);
        }

        // 듣도 보도 못한 사람 리스트
        ArrayList<String> result = new ArrayList<>();
        
        for (int i = 0; i < M; i++) {
            // 보도 못한 사람 
            String view = br.readLine();
            // 듣도 못한 사람에 포함돼 있으면 결과 리스트에 추가
            if (list.contains(view)) {
                result.add(view);
            }
        }
        
        // 듣보잡 리스트 정렬
        Collections.sort(result);

        System.out.println(result.size());
        for (String s : result) {
            System.out.println(s);
        }
    }
}
