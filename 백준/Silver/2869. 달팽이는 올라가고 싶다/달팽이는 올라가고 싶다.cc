#include <stdio.h>
#include <math.h> 
int main(void) 
{ 
    int a, b, v; 
    double result; 
    scanf("%d %d %d", &a, &b, &v); 
    result = ceil((double)(v - b) / (a - b)); 
    printf("%.0f", result); 
    return 0; 
}

