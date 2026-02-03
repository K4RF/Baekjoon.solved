import java.util.Scanner;

public class Main{
//    스택 배열(빈배열, 크기 미정)
    private static int[] stk;
//    스택 크기
    private static int size = 0;

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int N = sc.nextInt();
        stk = new int[N];

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

                case "top":
                    sb.append(top()).append("\n");
                    break;
            }
        }
        System.out.println(sb);
        sc.close();
    }

    public static void push(int x) {
        stk[size] = x;
        size++;
    }

    public static int pop() {
        if (size == 0) {
            return -1;
        } else {
            int res = stk[--size];
            stk[size] = 0;
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

    public static int top() {
        if (size == 0) {
            return -1;
        } else {
            return stk[size - 1];
        }
    }
}