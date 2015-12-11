public class CentCombo
{
	public static void main(String[] args)
	{
		int amount = Integer.parseInt(args[0]);

		int combos = getCombos(amount, 25);
		System.out.println(combos);
	}

	public static int getCombos(int a, int denom)
	{
		int nextDenom = 0;

		switch(denom)
		{
			case 25:
			{
				nextDenom = 10;
			}break;

			case 10:
			{
				nextDenom = 5;
			}break;

			case 5:
			{
				nextDenom = 1;
			}break;
			
			case 1:
			{
				return 1;
			}
		}
		
		int multipler = 0;
		int combos = 0;
		while(a - multipler*denom >= 0)
		{
			combos += getCombos(a - multipler*denom, nextDenom);
			++multipler;
		}

		return combos;
	}
}
