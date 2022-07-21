#include<stdio.h>

int main(void)
{
	int n, a, b, c;

	int i = 0;
	scanf("%d", &n);

	a = n / 10;
	b = n % 10;

	 while (n>=0 && n<=99)
	{	
		c = b;
		b = (a + b) % 10;
		a = c;

		i++;
		if (n == a * 10 + b)
		{
			break;
		}
	}
	printf("%d", i);

	return 0;

}