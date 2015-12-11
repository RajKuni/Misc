public class StringSearch
{
	public static void main(String[] args)
	{
		String[] strs = {"at", "", "", "", "", "ba", "", "ball", "car", "", "", "dad", "", ""};
		
		String toFind = args[0];
		
		System.out.println(index(strs, toFind, 0, strs.length - 1));
	}

	public static int index(String[] strs, String key, int firstIndex, int lastIndex)
	{
		int middleIndex = (firstIndex + lastIndex) / 2;
		
		int equiv = key.compareTo(strs[middleIndex]);
		System.out.println("equiv = " + equiv);

		if(equiv == 0)
		{
			return middleIndex;
		}

		if(middleIndex >= lastIndex)
		{
			return -1;
		}
		
		int newMiddle = middleIndex;
		int newFirst = firstIndex;

		while(strs[newMiddle] == "")
		{
			newMiddle--;
		}	

		while(strs[newFirst] == "")
		{
			newFirst++;
		}

		equiv = key.compareTo(strs[newMiddle]);

		if(equiv < 0)
		{
			return index(strs, key, newFirst, newMiddle - 1);
		}
		else if(equiv > 0)
		{
			return index(strs, key, newMiddle + 1, lastIndex);
		}
		else
		{
			return newMiddle;
		}
	}
}
