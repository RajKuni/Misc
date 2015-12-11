import java.util.*;

public class HeapTest
{
	public static void main(String[] args)
	{
		ArrayList<Integer> vals = new ArrayList<>();
		vals.add(3);
		vals.add(1);
		vals.add(6);
		vals.add(5);
		vals.add(2);
		vals.add(4);

		Heap<Integer> myHeap = new Heap<>(vals, true);

		for(int i = 0; i < myHeap.heap.size(); ++i)
		{
			System.out.print(myHeap.heap.get(i) + " ");
		}
		System.out.println("");	

		Integer top = myHeap.peek();
		System.out.println("Min: " + top);

		Integer delTop = myHeap.deleteTop();
		System.out.println("deleted Min: " + delTop);

		System.out.println("After Deletion: ");
		for(int i = 0; i < myHeap.heap.size(); ++i)
		{
			System.out.print(myHeap.heap.get(i) + " ");
		}
		System.out.println("");	
		
		Integer toInsert = 6;
		myHeap.insert(toInsert);	
		

		System.out.println("After Insertion: ");
		for(int i = 0; i < myHeap.heap.size(); ++i)
		{
			System.out.print(myHeap.heap.get(i) + " ");
		}
		System.out.println("");	

	}
}
