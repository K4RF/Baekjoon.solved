#include<stdio.h>
#pragma warning(disable:4996)
int main()
{
    int A,X,N;
    scanf("%d %d", &N, &X);
    for(int i = 1; i <= N; i++){
        scanf("%d", &A);
        if(A < X)
            printf("%d ", A);
    }
}