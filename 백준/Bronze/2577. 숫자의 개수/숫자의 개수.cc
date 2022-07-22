#include <stdio.h>
#pragma warning(disable:4996)
int main()
{
    int count[9];
    int a, b, c, result, tem;
    int zero = 0;
    int i = 0;
    while (i < 9)
    {
        count[i] = 0;
        i++;
    }
    i = 0;

    scanf("%d", &a);
    scanf("%d", &b);
    scanf("%d", &c);

    result = a * b * c;

    while (result > 0)
    {
        tem = result % 10;
        if (tem == 0)
            zero++;
        else if (tem > 0)
            count[tem - 1] += 1;
        result /= 10;
    }
    printf("%d\n", zero);
    while (i <= 8)
    {
        printf("%d\n", count[i]);
        i++;
    }

    return (0);
}