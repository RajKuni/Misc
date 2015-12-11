public class Parens
{
	public static void main(String[] args)
	{
		int pairs = Integer.parseInt(args[0]);
		char[] result = new char[pairs*2];
		genHelp(pairs, pairs, result, 0);
	}


	public static void genHelp(int l, int r, char[] result, int count)
	{
		if(l < 0 || r < 0)
		{
			return;
		}
		if(l == 0 && r == 0)
		{
			System.out.println(result);
		}
		else
		{
			if(l > 0)
			{
				//System.out.println("adding (");
				result[count] = '(';
				genHelp(l - 1, r, result, count + 1);
				//System.out.println(result);
				//System.out.println("returned (");
			}
			if(r > l)
			{
				//System.out.println("adding )");
				result[count] = ')';
				genHelp(l, r - 1, result, count + 1);
				//System.out.println(result);
				//System.out.println("returned )");
			}
		}
	}
}
