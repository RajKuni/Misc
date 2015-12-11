public class myArrayStack()
{
	Node[] myStackArray = new Node[n];

	int[] stackStarts = {0, n/3, 2n/3};
	int stackPointers = {0, 0, 0};

	public int push(int stackNo, Object item)
	{
		if(stackPointers[stackNo] > n/3) //overflow
		{
			return -1;
		}

		int thisStackStart = stackStart[stackNo];
		int nextFreeSpace = thisStackStart + stackPointers[stackNo];

		Node t = new Node(item);
		myStackArray[nextFreeSpace] = t;
		stackPointers[stackNo] += 1;
				

		return 1;
	}

	public Node pop(int stackNo)
	{
		if(stackPointers[stackNo] == 0)
		{
			return null;
		}

		int thisStackStart = stackStarts[stackNo];
		int topIndex = thisStackStart + stackPointers[stackNo] - 1;

		Node result = myStackArray[topIndex];
		stackPointers[stackNo] -= 1;

		return result;
	}
}

public class TripleStack()
{
	StackNode[] buffer;
	int[] stackPointers = {-1, -1, 1};
	int nextFree = 0;

	public TripleStack(int n)
	{
		buffer = new StackNode[n];
	}

	public int push(int stack, int value)
	{
		if(nextFree == buffers.size - 1)
		{
			return -1;
		}
		
		int oldHead = stackPointers[stack];
		buffer[nextFree] = new Node(v, oldHead);
		nextFree++;

		return 1;
	}

	public StackNode pop(int stack)
	{
		int stackHead = stackPointers[stack];
		Node result = buffer[stackHead];
		buffer[stackHead] = null;
		stackPointers[stack] = 
	}


}

public class StackNode()
{
	int value, previous;

	public StackNode(int v, int p)
	{
		previous = p;
		value = v;
	}
}

//Question 3.3:

public class SetOfStacks()
{
	int maxHeight, currentHeight = 0;
	ArrayList<Stack> stacks = new ArrayList<Stack>();

	public SetOfStacks(int n) //n = max stack Height 
	{
		maxHeight = n;
		stacks.add(new Stack());
	}
	
	public void push(Object t)
	{
		if(currentHeight < maxHeight)
		{
			currentStack.push(t);
			currentHeight++;
		}
		else
		{	
			stacks.add(new Stack());
			stacks(i).push(t);
			currentHeight = 1;	
		}
	}

	public Node pop()
	{
		int numStacks = stacks.size() - 1;
		Node result = stacks(numStacks).pop();
		currentHeight -= 1;

		//check to see if stack is empty after pop
		if(currentHeight == 0)
		{
			stacks(numStacks).remove();
			currentHeight = maxHeight; //we are at a full stack now. So adding anything will create new stack
		}
	}

	public Node specificPop(int stackNo)
	{
		Node result = stacks.get(stackNo).pop();

		int numStacks = stacks.size();
		
		for(int i = stackNo + 1;
			i < numStacks;
			++i)
		{
			Node rollover = stacks.get(i). 
			stacks.get(stackNo).p
		}	
	}

}

//exercise 3.2

//on insertion:

public class Stack()
{
	Node minimum = null;
	Node top = null;

	public Node pop()
	{
		if(top == null)
		{
			return null;
		}

		Node result = top;
		top = top.next();
		
		//now find the next lowest if the one removed was smallest
		if(result == minimum)
		{
			minimum = MAX_NODE; //set minimum to max
			minimum = findMinimum(top);
		}
	}

	public Node findMinimum(Node head)
	{
		if(head == null)
		{
			return minimum;
		}

		if(head < minimum)
		{
			minimum = head;
		}
		
		minimum = findMinimum(head.next());
	}

	public void push(int value)
	{
		Node t = new Node(value);
		t.next() = top;
		top = t;

		if(minimum != null)
		{
			minimum = top;
		}
		else if(top < minimum)
		{
			minimum = top;
		}
	}
}

public class Tower()
{
	int numOfDisks = 5;
	Stack a, b, c = new Stack();
	
	public static void main(String[] args)
	{	
		for(int i = 1; i <= numOfDisks; ++i)
		{
			a.push(i); //filling in a
		}
		
		shift(a, c, b, numOfDisks); //shift from a to c. b is spare rod
	}

	public static void shift(Stack source, Stack dest, Stack spare, int n)
	{
		if(n == 1)
		{		
			Node toShift = source.pop();
			dest.push(toShift.value());
			return;
		}
		
		shift(source, spare, dest, n - 1);
		
		Node toShift = source.pop();
		dest.push(toShift.value());

		shift(spare, dest, source, n - 1);
		
	}
}

public class myQueue()
{
	Stack in, out = new Stack();

	public void push(Object t)
	{
		in.push();
	}

	public Node pop()
	{
		Node result;

		if(out.top == null)
		{
			shiftToOut();
		}
		else
		{
			result =  out.pop();
		}

		return result;
	}

	public void shiftToOut()
	{
		while(in.top != null)
		{
			Node temp = in.pop();
			out.push(temp);
		}
	}
}

public void sortStack(Stack a, Stack spare)
{
	if(a.top == null || a.top.next() == null)
	{
		return; //no sorting required for a one size or empty stack
	}

	while(a.top() != null)
	{
		if(a.top().next() > a.top() || a.top().next() == null)
		{
			Node temp = a.pop();
			spare.push(temp);
		}
		else
		{
			Node temp = a.pop();
			spare.push(a.pop());
			a.push(temp);
		}
	}

	//now push all items from spare back to a
	while(spare.top() != null)
	{
		a.push(spare.push());
	}

}






























