#include<stdio.h>
#pragma warning(disable:4996)
int fibonach(int);
int main()
{
    int n;
    scanf("%d", &n);
    printf("%d", fibonach(n));
}
int fibonach(int n)
{
    int i;
    int res[20] = {0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
    for(i=2;i<=n;i++){
        res[i] = res[i-1] + res[i-2];
    }
    return(res[n]);
}