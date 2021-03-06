#include <stdio.h>

void mergeSort(int[], int, int);
void merge(int[], int, int, int);

//int main is just a test function. Can remove it and just use mergeSort & merge function
int main()
{
	int toSort[10] = {3, 2, 6, 3, 9, 2, 1, 12, 11, 99};
	int arrLen = 10;

	mergeSort(toSort, 0, arrLen - 1);

	printf("Sorted\n");

	for(int i = 0; i < arrLen; ++i)
	{
		printf("%d, ", toSort[i]);
	}
	printf("\n");
		
	return 0;
}

void mergeSort(int toSort[], int start, int end)
{
	//we don't need to split if start and end indexes are the same 
	if(start < end)
	{
		int middle = (end + start) / 2;
		mergeSort(toSort, start, middle);
		mergeSort(toSort, middle + 1, end);
		merge(toSort, start, middle, end);
	}
}

void merge(int toSort[], int start, int middle, int end)
{
	int firstLen = middle - start + 1;
	int secondLen = end - middle;
	
	//when I tried declaring int arrays with firstLen & secondLen as lengths,
	//I got compiler error stating it couldn't initialize an array of size 0???
	int *firstHalf = (int*)malloc(firstLen*sizeof(int));
	int *secondHalf = (int*)malloc(secondLen*sizeof(int));

	int i = 0;
	int j = 0;
	int k = start;

	//fill in temp arrays with values
	for(int i = 0; i < (middle - start + 1); ++i)
	{
		firstHalf[i] = toSort[start + i];
	}
	
	for(int i = 0; i < (end - middle); ++i)
	{
		secondHalf[i] = toSort[middle + 1 + i];
	}
	
	//this checks from which temp array we should get the next element
	while(i < (firstLen) && j < (secondLen))
	{
		if(firstHalf[i] < secondHalf[j])
		{
			toSort[k] = firstHalf[i];
			++i;
			++k;
		}
		else
		{
			toSort[k] = secondHalf[j];
			++j;
			++k;
		}
	}

	//add any remaining elements to the results array
	if(i < firstLen)
	{
		while(i < firstLen)
		{
			toSort[k] = firstHalf[i];
			++i;
			++k;
		}
	}

	if(j < secondLen)
	{
		while(j < secondLen)
		{
			toSort[k] = secondHalf[j];
			++j;
			++k;
		}
	}

	//free temp arrays
	free(firstHalf);
	free(secondHalf);

}
