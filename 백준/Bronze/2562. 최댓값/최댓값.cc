#include<stdio.h>
#pragma warning(disable:4996)
int main(){
    int i,n;
    int a[9];
    int max = -1000000;
    for(i=0;i<9;i++){
        scanf("%d",&a[i]);
        if(max <a[i]){
            max = a[i];
            n = i;
        }
    }
    printf("%d\n%d\n", max,n+1);
}