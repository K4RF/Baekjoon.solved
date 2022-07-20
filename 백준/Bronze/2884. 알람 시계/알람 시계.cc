#include<stdio.h>
#pragma warning(disable:4996)

int main(){
    int H, M;
    scanf("%d %d", &H, &M);
    M = M - 45;
    if(M < 0 ){
        H = H - 1;
        if(H < 0)
            H = 24 + H;
        M = 60 + M;
    }
    printf("%d %d\n", H, M);
}