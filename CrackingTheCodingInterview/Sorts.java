public class Sorts
{
	public static void main(String[] args)
	{
		int[] arr = {3, 5, 2, 7, 12, 1, 151, 4, 13, 90, 25};
		//int[] arr = {4, 2, 1, 3};

		//int[] result = mergeSort(arr, 0, arr.length - 1);
		quickSort(arr, 0, arr.length - 1);

		for(int i = 0; i < arr.length; ++i)
		{
			System.out.print(arr[i] + " ");
		}

	}

	public static int[] mergeSort(int[] arr, int first, int last)
	{
		if(arr.length == 0)
		{
			return null;
		}

		if(arr.length == 1)
		{
			return arr;
		}

		if(arr.length == 2)
		{
			if(arr[0] > arr[1])
			{
				int temp = arr[1];
				arr[1] = arr[0];
				arr[0] = temp;
			}
			return arr;
		}
		
	   int middle = (first + last) / 2; 

	   int[] left = new int[middle];
	   int[] right = new int[last - middle + 1];

		System.arraycopy(arr, first, left, 0, middle);
		System.arraycopy(arr, middle, right, 0, last - middle + 1);

	   left = mergeSort(left, 0, middle - 1);
	   right = mergeSort(right, 0, last - middle);

	   int[] result = new int[left.length + right.length];

	   int lIndex = 0;
	   int rIndex = 0;
	   int mainIndex = 0;

	   while(lIndex < left.length && rIndex < right.length)
	   {
			if(left[lIndex] < right[rIndex])
			{	
				result[mainIndex++] = left[lIndex++];
			}	
			else
			{
				result[mainIndex++] = right[rIndex++];
			}
	   } 

	   if(lIndex < left.length)
	   {
			while(lIndex < left.length)
			{
				result[mainIndex++] = left[lIndex++];
			}
	   }
	   else
	   {
			while(rIndex < right.length)
			{
				result[mainIndex++] = right[rIndex++];
			}

	   }

	   return result;
	}

	public static void quickSort(int[] arr, int left, int right)
	{
		int l = left;
		int r = right;

		int pivot = (left + right) / 2;

		while(l <= r)
		{
			while(arr[l] < arr[pivot])
			{
				l++;
			}
			while(arr[r] > arr[pivot])
			{
				r--;
			}
			if(l <= r)
			{
				int temp = arr[l];
				arr[l] = arr[r];
				arr[r] = temp;
				l++;
				r--;
			}	
		}
		
		if(left < l - 1)
		{
			quickSort(arr, left, l - 1);
		}
		if(l < right)
		{
			quickSort(arr, l, right);
		}
	}
}
