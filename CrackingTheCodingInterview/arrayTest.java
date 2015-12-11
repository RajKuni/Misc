import java.util.*;

public class arrayTest
{
	public static void main(String[] args)
	{
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		//fill this array in. I assume that since this array will
		//be passed in by reference (its pointer will be passed in)
		//that it will be filled after below method executes
		
		fillList(list, 0, 10);

		for(int i = 0; i < list.size(); ++i)
		{
			System.out.print(list.get(i) + " ");
		}

		System.out.println("\n");
	}

	public static void fillList(ArrayList<Integer> l, int start, int end)
	{
		if(start == end)
		{
			return;
		}
		else
		{
			l.add(start);
			fillList(l, ++start, end);
		}
	}
}
