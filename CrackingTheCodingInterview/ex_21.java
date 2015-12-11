public Node removeDuplicates(Node head)
{
	Node n = head;
	while(n.next() != null)
	{
		Node m = head;
		
		while(m.next() != null)
		{
			if(m.next().value() == n.value())
			{
				Node x = m;
				while(x.next().value() == n.value())
				{
					x = x.next();
				}
				m.next() = x.next();
			}	
			m = m.next();
		}
		n = n.next();
	}
}

public Node find(Node head, int index)
{

	if(head == null)
	{
		return null;
	}
	else if(index == 0)
	{
		return head;
	}
	else if(index > 0)
	{
		return find(head.next(), index - 1);
	}
}

public Node deleteMiddle(Node toDelete)
{
	Node temp = toDelete.next();
	toDelete = temp;
	toDelete.next() = temp.next();
}

public int calcSum(Node a, Node b)
{
	int sumA, sumB = 0;
	int counter = 0;

	if(a != null)
	{

		while(a != null)
		{
			sumA += a.value()*10^counter;
			a = a.next();
			++counter;
		}
	}
		
	counter = 0;

	if(b != null)
	{

		while(b != null)
		{
			sumB += b.value()*10^counter;
			b = b.next();
			++counter;
		}
	}
	return (sumA + sumB);	
}

