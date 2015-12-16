import java.util.*;

public class Distinct
{
	public static void main(String[] args)
	{
		int[] arr = {2,3,2,45,3,3,5,9,5,1,12,23,4};
		int numDistinct = findDistinct(arr);
		System.out.println("# distinct numbers in array: " + numDistinct);
	}

	public static int findDistinct(int[] arr)
	{
		HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
		int distinctCount = 0; 
		
		for(int i = 0; i < arr.length; ++i)
		{
			if(hm.get(arr[i]) == null)
			{
				++distinctCount;
			    hm.put(arr[i], 1);	
			}
		}

		return distinctCount;
	}
}
