import java.util.*;

public class Heap<T extends Comparable<T>>
{
	public ArrayList<T> heap = new ArrayList<>();
	private int sortOrder; //if min heap, 1 else -1

	public Heap(boolean maxHeap)
	{
		sortOrder = maxHeap ? -1 : 1;
	}

	public Heap(ArrayList<T> values, boolean maxHeap)
	{
		sortOrder = maxHeap ? -1 : 1;
		heap.addAll(values);
		heapify();
	}

	public void heapify()
	{
		int downHeapIndex = heapify(0);
		percolateDown(downHeapIndex);
	}

	public int heapify(int index)
	{
		
		T parent = heap.get(index);
		int leftChildIndex = ((index + 1) << 1) - 1;
		int rightChildIndex = ((index +1) << 1);

		//check if index corresponds to a leaf node
		if(leftChildIndex >= heap.size())
		{
			return 0;
		}	

		//go down a level
		heapify(leftChildIndex);
		if(rightChildIndex < heap.size())
		{
			heapify(rightChildIndex);
		}

		T left = heap.get(leftChildIndex);
		int leftCheck = left.compareTo(parent)*sortOrder; 

		if(rightChildIndex >= heap.size())
		{
			//only check left child, swap with parent
			if(leftCheck < 0)
			{
				swap(index, leftChildIndex);
				return leftChildIndex;
			}
			return 0;
		}

		//current node has left and right children
		T right = heap.get(rightChildIndex);
		int rightCheck = right.compareTo(parent)*sortOrder;
		
		if(rightCheck < 0 && leftCheck < 0)
		{
			//both children less than parent, swap smaller child
			int childCompare = left.compareTo(right)*sortOrder;
			if(childCompare < 0)
			{
				swap(index, leftChildIndex); 
				return leftChildIndex;
			}
			else
			{
				swap(index, rightChildIndex);
				return rightChildIndex;
			}
		}
		else if(leftCheck < 0)
		{	
			swap(index, leftChildIndex);
			return leftChildIndex;
		}
		else if(rightCheck < 0)
		{
			swap(index, rightChildIndex);
			return rightChildIndex;
		}
		else
		{
			//no swap
			return 0;
		}
		
	}

	public void percolateDown(int index)
	{
		T parent = heap.get(index);
		int leftChildIndex = ((index + 1) << 1) - 1;
		int rightChildIndex = ((index +1) << 1);

		if(leftChildIndex >= heap.size())
		{
			return;
		}	
		
		T left = heap.get(leftChildIndex);
		int leftCheck = left.compareTo(parent)*sortOrder;
		
		if(rightChildIndex >= heap.size())
		{
			//only left child to compare
			if(leftCheck < 0)
			{
				swap(index, leftChildIndex);
			}
			return;
		}

		//two children to compare
		T right = heap.get(rightChildIndex);
		int rightCheck = right.compareTo(parent)*sortOrder;

		if(leftCheck < 0 && rightCheck < 0)
		{
			int childrenCheck = left.compareTo(right)*sortOrder;
			if(childrenCheck < 0)
			{
				//left child smaller than right child
				swap(index, leftChildIndex);
				percolateDown(leftChildIndex);
			}
			else
			{
				swap(index, rightChildIndex);
				percolateDown(rightChildIndex);	
			}
		}
		else if(leftCheck < 0)
		{
			swap(index, leftChildIndex);
			percolateDown(leftChildIndex);
		}
		else if(rightCheck < 0)
		{
			swap(index, rightChildIndex);
			percolateDown(rightChildIndex);	
		}
		else
		{
			return;
		}
	}

	public void percolateUp(int index)
	{
		T current = heap.get(index);
		int parentIndex = ((index - 1) >> 1);

		//restrict parent to be >= 0
		parentIndex = parentIndex < 0 ? 0 : parentIndex;

		if(index == 0)
		{
			return;
		}

		T parent = heap.get(parentIndex);
		int check = parent.compareTo(current)*sortOrder;
		
		if(check < 0)
		{
			//new value is not less than parent, stop percolation
			return;
		}
		else
		{
			//new value is less than parent, percolate up
			swap(index, parentIndex);
			percolateUp(parentIndex);
		}

	}

	public T peek()
	{
		return heap.get(0);
	}

	public T deleteTop()
	{
		T min = heap.get(0);
		if(heap.size() > 1)
		{
			T last = heap.get(heap.size() - 1);
			heap.set(0, last);
			heap.remove(heap.size() - 1);
			percolateDown(0);
		}
		else
		{
			heap.clear();
		}

		return min;
	}

	public void insert(T toInsert)
	{
		heap.add(toInsert);
		percolateUp(heap.size() - 1);
	}

	public void swap(int i1, int i2)
	{
		T t1 = heap.get(i1);
		T t2 = heap.get(i2);
		
		heap.set(i1, t2);
		heap.set(i2, t1);
	}

}
