#include<stdio.h>
#pragma warning(disable:4996)
int main() {
    int M, N;
    int sum = 0, min = 1000000;
    scanf("%d %d", &M, &N);
    for (M; M <= N; M++) {
        for (int j = 2; j <= M; j++) {
            if (M % j == 0) {
                if (M == j) {
                    sum += M;
                    if (M < min)
                        min = M;
                }
                else { break; }
            }
        }
    }
    if (sum == 0 || min == 1000000)
        printf("-1");
    else
        printf("%d\n%d\n", sum, min);
}