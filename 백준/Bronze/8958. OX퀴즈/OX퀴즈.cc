#include <stdio.h>
#pragma warning(disable:4996)

int main(void)
{
    int num, sum1, sum2;
    char s[100][80];

    scanf("%d", &num);

    for (int i = 0; i < num; i++)
    {
        scanf("%s", &s[i], sizeof(s[i]));
    }

    for (int i = 0; i < num; i++)
    {
        sum1 = 0, sum2 = 0;
        for (int j = 0; s[i][j] != NULL; j++)
        {
            if (s[i][j] == 'O')
            {
                sum1++;
                sum2 += sum1;
            }
            else if (s[i][j] == 'X')
            {
                sum1 = 0;
            }
        }
        printf("%d\n", sum2);
    }

    return 0;
}