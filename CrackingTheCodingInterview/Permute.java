import java.util.*;

public class Permute
{
	public static void main(String[] args)
	{
		String input = args[0];
		
		ArrayList<String> combos = gen(input);

		System.out.println("Number of Permutes: " + combos.size());

		for(String s: combos)
		{
			if(s.length() == input.length())
			{
				System.out.println(s);
			}
		}
	}

	public static ArrayList<String> gen(String input)
	{
		ArrayList<String> result = new ArrayList<String>();
		
		if(input.length() == 0)
		{
			return null;
		}
		
		if(input.length() == 1)
		{
			result.add(input);
			return result;
		}

		if(input.length() == 2)
		{
			//add original to list
			result.add(input);

			//swap characters, add this to list
			StringBuilder st = new StringBuilder(input);
			st.setCharAt(0, input.charAt(1));
			st.setCharAt(1, input.charAt(0));
			
			String perm = st.toString();	
			result.add(perm);
			return result;
		}

		//divide into smaller string with this recursive call
		ArrayList<String> subResult = gen(input.substring(1));
			
		for(int i = 0; i < subResult.size(); ++i)
		{
			String temp = subResult.get(i);
			String first = input.substring(0, 1);
			String full = first.concat(temp);
			
			//add this concatenated string to list
			result.add(full);
			
			for(int j = 1; j < full.length(); ++j)
			{
				char[] shifts = full.toCharArray();
				char t = shifts[j];
				shifts[j] = shifts[j - 1];
				shifts[j - 1] = t;
				result.add(new String(shifts));
			}
		}

		return result;	
	}
}
