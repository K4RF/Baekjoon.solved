#include <stdio.h>
#pragma warning(disable:4996)

int main() {
	int arr[10];
	int count1=0;
	for (int i = 0; i < 10; i++)
	{
		scanf("%d", &arr[i]);
	} 

	for (int i = 0; i < 10; i++) {
		int count = 0;
		arr[i] = arr[i] % 42;
		for (int j = 0; j < i; j++) {
			if (arr[i] == arr[j]) count++;
		}
		if (count == 0) count1++;
	}
	printf("%d", count1);
	}