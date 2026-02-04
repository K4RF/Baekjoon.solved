import java.util.Scanner;

public class Main{
    //    큐 배열(빈배열, 크기 미정)
    private static int[] queue;
    //    큐 크기
    private static int size = 0;
    //    큐 포인터
    private static int front = 0;
    private static int back = 0;

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int N = sc.nextInt();
        queue = new int[N];

        for (int i = 0; i < N; i++) {
            String str = sc.next();

            switch (str) {
                case "push":
                    push(sc.nextInt());
                    break;

                case "pop":
                    sb.append(pop()).append("\n");
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

    public static void push(int x) {
        queue[back++] = x;
        size++;
    }

    public static int pop() {
        if (size == 0) {
            return -1;
        } else {
            int res = queue[front];
            queue[front++] = 0;     // 현재의 맨 앞 값을 0으로 초기화하고 큐 포인터 증가
            size--;        // 사이즈 감소
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
            return queue[front];
        }
    }

    public static int back() {
        if (size == 0) {
            return -1;
        } else {
            return queue[back - 1];
        }
    }
}