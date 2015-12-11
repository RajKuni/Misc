public class RotatedSearch
{
	public static void main(String[] args)
	{
		int[] rot = {10, 14, 15, 16, 19, 20, 25, 1, 3, 4, 5,7};

		int toFind = Integer.parseInt(args[0]);

		int index = find(rot, toFind, 0, rot.length - 1);

		System.out.println(index);
	}

	public static int find(int[] arr, int key, int firstIndex, int lastIndex)
	{
		int middleIndex =  (firstIndex + lastIndex) / 2;
		
		if(arr[middleIndex] == key)
		{
			return middleIndex;
		}	

		if(middleIndex >= lastIndex)
		{
			return -1;
		}
	
		if(key < arr[middleIndex])
		{	
			if(key >= arr[firstIndex])
			{
				return find(arr, key, firstIndex, middleIndex - 1);
			}
			else
			{
				return find(arr, key, middleIndex + 1, lastIndex);
			}
		}
		else
		{
			return find(arr, key, middleIndex + 1, lastIndex);
		}
	}
}
