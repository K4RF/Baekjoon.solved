#include <stdio.h>
#pragma warning(disable:4996)
int main()
{
    int N,i,j;
    scanf("%d", &N);
    for(i=1;i<=N;i++)
        for(j=1;j<=i;j++){
            printf("*");
            if(j==i)
                printf("\n");
        }
}