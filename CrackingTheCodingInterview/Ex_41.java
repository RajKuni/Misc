public ArrayList<LinkedList<Node>> mapTree(Node head)
{
	ArrayList<LinkedList<Node>> result = new ArrayList<LinkedList<Node>>();

	int level = 0;

	LinkedList<Node> l = new LinkedList<Node>();
	l.add(head);
	result.add(l);

	while(true)
	{
		LinkedList<Node> newList = new LinkedList<Node>();

		for(int i = 0; i < result.get(level).size(); ++i)
		{
			Node curr = (Node)result.get(level).get(i);

			if(curr.left)
			{
				newList.add(curr.left);
			}
			if(curr.right)
			{
				newList.add(curr.right);
			}
		}

		if(l.get(0) == null)
		{
			break; //this level does not contain any nodes so we are done
		}
		else
		{
			result.add(newList);
			++level;
		}
	}

	return result;
}

public Node findSuccessor(Node target)
{
	if(target.parent == null && target.right == null)
	{
		return target; //no right subtree or parent
	}	
	else if(target.parent > target && target.right == null)
	{
		return target.parent;
	}
	else if(target.parent < target && target.right == null)
	{
		Node p;
		
		while((p = target.parent) != null)
		{
			if(p.left == target)
			{
				return p;
			}
			else
			{
				target = target.parent;
			}
		}	

		return null;
	}
	else //there is a right subtree
	{
		Node result = findMinimum(target.right);	
	}
}

public Node findMinimum(Node h)
{
	if(h.left == null)
	{
		return h;
	}
	else
	{
		return findMinimum(h.left);
	}
}

public Node common(Node a, Node b)
{
	int levelA = level(a);
	int levelB = level(b);

	if(levelA > levelB)
	{
		a = goUp(a, levelA - levelB); //move up the difference in levels for the node that is deeper
	}
	else
	{
		b = goUp(b, levelB - levelA);
	}
	
	Node result;

	while(true)
	{
		if(a == b)
		{
			return a;
		}
		else
		{
			a = a.parent;
			b = b.parent;
		}
	}
}

public int level(Node a)
{
	if(a.parent == null)
	{
		return 0; //at very top of tree
	}
	else
	{
		return 1 + level(a.parent);
	}
}

public Node goUp(Node a, int levels)
{
	if(levels == 0)
	{
		return a;
	}
	else
	{
		return goUp(a.parent, levels - 1);
	}
}


public Node getCommon(Node root, Node a, Node b)
{
	if(covers(root.left, a) && covers(root.left, b))
	{
		return getCommon(root.left, a, b);
	}
	else if(covers(root.right, a) && covers(root.right, b))
	{
		return getCommon(root.right, a, b);
	}
	else
	{
		return root;
	}
}

public boolean covers(Node root, Node a)
{
	if(root == b)
	{
		return false;
	}
	if(root == a)
	{
		return true;
	}
	else
	{
		return covers(root.left, a) || covers(root.right, a);
	}

}

//problem 4.7, find out if T2 is a subtree of T1

public boolean subTree(Node t1, Node t2)
{
	ArrayList<Node> treeOne = new ArrayList<Node>();
	traverse(t1, treeOne); //passing
}

public ArrayList<Node> traverse(Node head, theList)
{
	if(head == null)
	{
		return theList;
	}	

	theList.add(head);
	traverse(head.left, theList);
	traverse(head.right, theList);
	
	return theList;	
}

public int traverse(int[] list, int pos, Node head)
{
	if(head == null)
	{
		return pos;
	}
	
	pos =  traverse(list, pos, head.left);	
	list[pos++] = Node.value();
	pos = traverse(list, pos, head.right);
	
	return pos;	
}

//find out if T2 is subtree of T1


public boolean isSub(Node t1, Node t2)
{
	if(t2 == null)
	{
		return true;
	}
	else
	{
		return subTree(t1, t2);
	}
}

public boolean subTree(Node t1, Node t2)
{
	if(t1 == null) //ran out of big tree
	{
		return false;
	}
	
	if(t1 == t2)
	{
		return matchTree(t1, t2);
	}
	else
	{
		return subTree(t1.left, t2) || subTree(t1.right, t2);
	}	
}

public boolean matchTree(Node t1, Node t2)
{
	if(t1 == null && t2 == null)
	{
		return true;
	}
	else if(t1 == null || t2 == null)
	{
		return false;
	}
	else if(t1 != t2)
	{
		return false;
	}
	else
	{
		return matchTree(t1.left, t2.left) && matchTree(t1.right, t2.right);
	}
}


//below will calculate all paths that sum up to a particular value

public void getPaths(Node head, int target, int level, ArrayList<Integer> path)
{

	if(head == null) //cannot go further
	{
		return;
	}

	path.add(head.value);
	int tmp = target;

	for(int i = level; i > -1; --i)
	{
		tmp -= path.get(i);
	   	if(temp == 0)
		{
			printPath(path, i, level);
		}	
	}

	ArrayList<Integer> c1 = (ArrayList<Integer>)path.clone();
	ArrayList<Integer> c2 = (ArrayList<Integer>)path.clone();
	
	getPaths(head.left, target, level + 1, c1);
	getPaths(head.right, target, level + 1, c2);
}



