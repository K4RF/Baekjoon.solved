#include <stdio.h>
#pragma warning(disable:4996)
int main()
{
    int max=-1000000,min=1000000;
    int N,input;
    scanf("%d", &N);
    for(int i =0; i<=N;i++){
        scanf("%d", &input);
        if(max < input)
            max=input;
        if(min > input)
            min=input;
    }
    printf("%d %d\n", min, max);
    return 0;
}