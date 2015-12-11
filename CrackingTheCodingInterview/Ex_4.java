public int isBalanced(Node head)
{
	int lHeight;
	int rHeight;

	if(head == null)
	{
		return 0;
	}
	else
	{
		 lHeight = 1 + isBalanced(head.left);
		 rHeight = 1 + isBalanced(head.right);
	}

	return Math.max(lHeight, rHeight);

}

public boolean pathExists(Node a, Node b, Stack s)
{
	if(a == b)
	{
		return true;
	}
	else 
	{
		a.state = 1;
		s.push(a);

		for(Node u : a.getAdjacent())
		{
			if(u.state == 0)
			{
				return true && pathExists(u, b, s);
			}
		}
		
		s.pop(a);

		if(s.isEmpty())
		{
			return false;
		}
		else
		{
			return true;
		}
	}
}

public enum State
{
	Visited, Unvisited;
}

public boolean pathExists(Graph g, Node a, Node b)
{
	For(Node u : g.getNodes())
	{
		u.state = Unvisited; 
	}

	LinkedList<Node> l = new LinkedList<Node>();
	
	a.state = Visited;
	l.add(a);
	
	while(!l.isEmpty())
	{
		a = l.removeFirst(); 
		for(Node u : a.getAdjacent())
		{	
			if(u == b)
			{
				return true;
			}

			if(u.state != Visited)
			{
				l.add(u);
			}
		}
	}

	return false;


}

public void Node createTree(int[] nums, int start, int end)
{
	if(end < start)
	{
		return null;
	}
	else
	{
		int middle = (start + end)/2;
		Node n = new Node(nums[middle]);
		n.left = createTree(nums[middle - 1], start, middle - 1);
		n.right = createTree(nums[middle + 1], middle + 1, end);
		return n;
	}
	
}
	
public LinkedList mapTree(Node head) //head of tree
{
	LinkedList<LinkedList> masterList = new LinkedList<LinkedList>();
	LinkedList<Node> q = new LinkedList<Node>();
	
	int level = 1;
		
	q.add(head);
	
	while(q.get(0) != null)
	{
		LinkedList<Node> temp = new LinkedList<Node>();
		for(i = 0; i < level; ++i)
		{
			Node h = q.removeFirst()
			q.add(h.left);
			q.add(h.right);
			temp.add(h);
		}
		masterList.add(temp);
		level = level*2;
	}
	return masterList;
}

public Node successor(Node n)
{
	if(n.parent == null || n.right != null)
	{
		return findMin(n.right);
	}
	else
	{
		Node p;
		while((p = n.parent) != null)
		{
			if(p.left == n)
			{
				break;
			}
			n = p;
		}
		return p;
	}
}


public Node findMin(Node n)
{
	if(n == null)
	{
		return null;
	}
	else
	{
		return findMin(n.left);
	}
}
