#include<stdio.h>
#pragma warning(disble:4996)

int main(){
    int n;
    int sum = 0;
    scanf("%d", &n);
    for(int i = 1; i <= n; i++)
        sum = sum + i;
    printf("%d\n", sum);
}