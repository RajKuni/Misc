public class UglyNumber
{
	public static void main(String[] args)
	{
		int kth = Integer.parseInt(args[0]);
		int[] sequence = new int[kth];

		Heap<Integer> myHeap = new Heap<>(false);

		myHeap.insert(1);
		
		int prev = 0;

		for(int i = 0; i < kth; ++i)
		{
			int min = myHeap.deleteTop();
			
			if(min == prev) //duplicate?
			{
				--i;
				continue;
			}

			sequence[i] = min;
			myHeap.insert(3*min);
			myHeap.insert(5*min);
			myHeap.insert(7*min);

			prev = min;
		}
		
		System.out.println("kth ugly number is: " + sequence[kth - 1]);
	}
}

/*class Triplet implements Comparable
{
	public int i;
	public int j;
	public int k;
	public int value;

	public Triplet(int i, int j, int k)
	{
		this.i = i;
		this.j = j;
		this.k = k;
		value = 3*i 
	}

	@Override
	public int compareTo(Triplet t)
	{

	}
}*/
