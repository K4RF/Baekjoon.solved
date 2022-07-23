#include <stdio.h>

int selfnumber(int i);

int main(void)
{
	int arr[10036] = { 0, }; // 0으로 초기화
	int num;
	for (int i = 1; i <= 10000; i++)
	{
		num = selfnumber(i);
		arr[num] = 1;
		 
	}
	for (int j = 1; j <= 10000; j++)
	{
		if (arr[j] == 0)
		{
			printf("%d\n", j);
		}
	}
	
	return 0;
}


int selfnumber(int i)
{
	int sum = i;

	while (i > 0)
	{
		sum += i % 10;
		i /= 10;
	}
	return sum;
}