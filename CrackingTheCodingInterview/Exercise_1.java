public class Exercise_1
{
	public static void main(String[] args)
	{
		String arg1 = args[0];
		fullyUniqueString(arg1);
	}

	public static void
	fullyUniqueString(String word)
	{
		int[] charRepeats = new int[24];
		int wordLen = word.length();
		
		//convert string to lower case
		word = word.toLowerCase();
			
		for(int index = 0;
			index < wordLen;
			++index)
		{
			char currChar = word.charAt(index);
			int charVal = (int)currChar;
			
			//lowercase 'a' is 97. it needs to mapped to first index of array
			//then increment array index value by one
			charVal = charVal - 97;
			charRepeats[charVal]++;	
		}	

		//loop through the array and stop if we find a value greater than 1
		int arrayLen = charRepeats.length;
		boolean allUnique = true; 
			
		for(int index = 0;
			index < arrayLen;
			++index)
		{
			if(charRepeats[index] > 1)
			{
				allUnique = false;
				break;
			}
		}
		//looped through array, characters are all unique
		if(allUnique)
		{
			System.out.println("String contains all unique characters!");
		}
		else
		{
			System.out.println("String does not contain all unique characters");
		}
	}
}

