
import java.util.Scanner;

public class Main{
    // 큐 배열 (명령어 수 N이 최대 10,000이므로, 앞뒤 여유를 두고 20001로 설정)
    // 0 ~ 10000 (front 방향), 10000 ~ 20000 (back 방향)
    private static int[] deque = new int[20001];
    //    덱 크기
    private static int size = 0;

    // 덱 포인터 - 시작점을 배열의 정중앙인 10000으로 설정
    private static int front = 10000;
    private static int back = 10000;

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int N = sc.nextInt();

        for (int i = 0; i < N; i++) {
            String str = sc.next();

            switch (str) {
                case "push_front":
                    push_front(sc.nextInt());
                    break;

                case "push_back":
                    push_back(sc.nextInt());
                    break;

                case "pop_front":
                    sb.append(pop_front()).append("\n");
                    break;

                case "pop_back":
                    sb.append(pop_back()).append("\n");
                    break;

                case "size":
                    sb.append(size()).append("\n");
                    break;

                case "empty":
                    sb.append(empty()).append("\n");
                    break;

                case "front":
                    sb.append(front()).append("\n");
                    break;

                case "back":
                    sb.append(back()).append("\n");
                    break;
            }
        }
        System.out.println(sb);
        sc.close();
    }

    public static void push_front(int x){
        deque[--front] = x;
        size++;
    }
    public static void push_back(int x) {
        deque[back++] = x;
        size++;
    }

    public static int pop_front() {
        if (size == 0) {
            return -1;
        } else {
            int res = deque[front];
            deque[front++] = 0;     // 현재의 맨 앞 값을 0으로 초기화하고 큐 포인터 증가
            size--;        // 사이즈 감소
            return res;
        }
    }

    public static int pop_back() {
        if (size == 0) {
            return -1;
        } else {
            int res = deque[--back];
            deque[back] = 0;
            size--;
            return res;
        }
    }

    public static int size() {
        return size;
    }

    public static int empty() {
        if (size == 0) {
            return 1;
        } else {
            return 0;
        }
    }

    public static int front() {
        if (size == 0) {
            return -1;
        } else {
            return deque[front];
        }
    }

    public static int back() {
        if (size == 0) {
            return -1;
        } else {
            return deque[back - 1];
        }
    }
}