import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 1; i <= N; i++) {
            list.add(i);
        }

        StringBuilder sb = new StringBuilder();
        sb.append("<");

        // 현재 위치 변수 (처음 시작 인덱스는 0)
        int index = 0;

        // 리스트에 사람이 모두 제거될 때까지 반복
        while (list.size() > 0) {

            /**
             * # 다음으로 제거할 사람의 인덱스 계산
             * 1. + K : 현재 위치에서 K번째 사람을 건너뜀
             * 2. - 1 : 방금 사람이 한 명 삭제되면서 뒤에 있던 사람들의 인덱스가 1씩 앞으로 당겨졌으므로 보정
             * 3. % list.size() : 사람들이 원형으로 앉아있으므로, 인덱스가 리스트 크기를 넘어가면 다시 처음으로 돌아오도록(순환)
             */
            index = (index + K - 1) % list.size();

            // 계산된 인덱스 위치의 사람을 리스트에서 제거하고, 그 값을 StringBuilder에 추가   
            sb.append(list.remove(index)).append(", ");
        }
        sb.delete(sb.length() - 2, sb.length());
        sb.append(">");
        bw.write(sb.toString() + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}