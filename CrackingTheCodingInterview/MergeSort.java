import java.util.*;

public class MergeSort
{

	public static void main(String[] args)
	{
		int[] toSort = new int[10];
		
		for(int i = 0; i < toSort.length; ++i)
		{
			toSort[i] = (int)(Math.random()*100);
		}

		for(int i = 0; i < toSort.length; ++i)
		{
			System.out.print(toSort[i] + ",");
		}
		System.out.print("\n");

		mergeSort(toSort, 0, toSort.length - 1);

		for(int i = 0; i < toSort.length; ++i)
		{
			System.out.print(toSort[i] + ",");
		}
		System.out.print("\n");
	}

	public static void mergeSort(int[] toSort, int p, int r)
	{
		if(p < r)
		{
			int mid = (p + r)/2;
			mergeSort(toSort, p, mid);
			mergeSort(toSort, mid + 1, r);
			merge(toSort, p, mid, r);
		}
	}

	public static void merge(int[] toSort, int p, int q, int r)
	{
		int[] low = new int[q - p + 1];
		int[] high = new int[r - q];
		System.arraycopy(toSort, p, low, 0, low.length);
		System.arraycopy(toSort, q + 1, high, 0, high.length);

		int lowLength = low.length;
		int highLength = high.length;

		int i = 0;
		int j = 0;
		int k = p;

		while(i < lowLength && j < highLength)
		{
			if(low[i] < high[j])
			{
				toSort[k] = low[i];
				k++;
				i++;
			}
			else
			{
				toSort[k] = high[j];
				k++;
				j++;
			}
		}

		if(i < lowLength)
		{
			while(i < lowLength)
			{
				toSort[k] = low[i];
				k++;
				i++;
			}
		}
		else if(j < highLength)
		{
			while(i < lowLength)
			{
				toSort[k] = high[j];
				k++;
				j++;
			}
		}
	}
} 

for(int i = 1; i < aLen; ++i)
        {
            int beforeSum = 0;
            //below loop calculates sum of all numbers before equilibrium
            for(int j = 0; j < i; ++j)
            {
                beforeSum += A[j];
            }
            
            int afterSum = 0;
            //this loop calculates sum of all numbers after equilibrium index
            for(int j = i + 1; j < aLen; ++j)
            {
                afterSum += A[j];   
            }
            
            if(afterSum == beforeSum)
            {
                return i; //equilibrium index found
            }
        }

int countDownPlaces = places;
        int max = 0;
        while(countDownPlaces >= 0)
        {
            int toAdd = 1;
            for(int i = 0; i <= countDownPlaces; ++i)
            {
                toAdd *= 10;
            }
            
            for
            
            toAdd += X;
            
            if(toAdd > max)
            {
                max = toAdd;
            }
            --countDownPlaces;
        }
