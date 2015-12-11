public class MergeArrays
{
	public static void main(String[] args)
	{
		//int aSize = Integer.parseInt(args[0]);
		//int bSize = Integer.parseInt(args[1]);

		int[] a1 = {3, 5, 6, 7, 8, 12, 17, 18, 20, 24, 0, 0, 0, 0, 0};
		int[] b1 = {4, 9, 10, 22, 26};

		merge(a1, b1);

		System.out.print("Sorted: ");
	    
		for(int i = 0; i < a1.length; ++i)
		{
			System.out.print(a1[i]);
			System.out.print(",");
		}	
		System.out.println("");
	}

	public static void merge(int[] a, int[] b)
	{
		int a_index = 0;
		int nextFreeBuffer = a.length - b.length;

		for(int index = 0; index < b.length; ++index)
		{
			int bVal = b[index];

			//search inside a where we can insert this #
			for(int i = a_index; i < a.length; ++i)
			{
				if(i == nextFreeBuffer)
				{
					//if nothing greater found, stick value to end of array
					a[nextFreeBuffer] = bVal;
					++nextFreeBuffer;
					break;
				}

				if(a[i] >= bVal)
				{
					//shift everything from i to a.length - 1 up one place
					for(int j = nextFreeBuffer; j > i; --j)
					{
						a[j] = a[j - 1]; //shift every # up by one index
					}	

					//now insert b number into a
					a[i] = bVal;
					a_index = i + 1;
					++nextFreeBuffer;
					break;
				}
			}
		}
	}
}
