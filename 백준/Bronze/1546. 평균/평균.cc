#include<stdio.h>
#pragma warning(disable:4996)

int main(){
    int M = -1000000;
    int n;
    double Avg = 0;
    double score[1001];
    scanf("%d", &n);
    for(int i = 0; i < n; i++){
        scanf("%lf", &score[i]);
        if( M < score[i])
            M = score[i];
    }
    for(int i = 0; i < n; i++){
        score[i] = score[i]/M*100;
        Avg += score[i];
    }
    printf("%lf", Avg/n);
}