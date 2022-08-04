#include <stdio.h>
#pragma warning(disable:4996)

int main(){
    int s, cnt = 0;
    scanf("%d", &s);
    while(s % 5 != 0){
        if(s < 0)
            break;
        s -= 3;
        cnt++;
    }
    if(s >= 0)
        printf("%d", cnt+s/5);
    else
        printf("-1");
    
    return 0;
}