public int insert(int n, int m, int i, int j)
{
	//shift m left by i
	m = m << i;

	//get top 32 - j bits into seperate var.
	int top = n >> (j + 1);
	top = n << (j + 1)

	//do the same to bottom i bits
	int bottom = n << (32 - i);
	bottom = bottom >> (32 - i);

	//or everything back together
	
	int result = top | bottom | m; 	
}

public void printBinary(float m)
{
	int whole = (int)m; //extract eveerything on left side of the decimal

	int deci = m - whole; //this gets the decimal part

	Stack s = new Stack();

	while(whole > 0)
	{
		if(whole % 2 != 0)
		{
			s.push(0);
		}
		else
		{
			s.push(1);
		}

		whole = whole / 2;
	}

	//print everything out of the stack
	while(!s.isEmpty())
	{
		System.out.print(s.pop());
	}

	//now convert decimal to binary decimal
	while(deci > 0.000000000001)
	{
		deci = deci*2;
		if(deci > 1)
		{
			System.out.print("1");
			deci = deci - 1;
		}
		else
		{
			System.out.print("0");
		}
	}
}

public void adj(int k)
{
	int temp = k;
	int one = 1;
	int shifts = 0;

	while(true)
	{
		if(temp & one == 1)
		{
			break;
		}
		temp = temp >> 1;
		++shifts;
	}

	int top = k >> shifts + 1;
	top = top << shifts + 1;
	
	int shiftLeft = k << (32 - (shifts + 1));
    shiftLeft = shiftLeft >> ((32 - (shifts + 1)) + 1); 	
	
	int smaller = top | shiftLeft;
	
	top = k >> shifts + 1;
	top = top + 1;
	top = top << shifts + 1;

	shiftLeft = k << (32 - (shifts + 1));
	shiftLeft = k >> (32 - (shifts + 1));

	int larger = top | shiftLeft;
}

public int numberOfOnes(int a, int b)
{
	//find # of ones in a
	int onesA = 0;
	while(a > 0)
	{
		if(a % 2 == 1)
		{
			++onesA;
		}
		a = a / 2;
	}

	//find # of ones in b
	int onesB = 0;
	while(b > 0)
	{
		if(b % 2 == 1)
		{
			++onesB;
		}
		b = b / 2;
	}

	return abs(onesA - onesA);
}

public int swap(int a)
{
	int max = ~0;
	int result = a ^ max;
	return result;
}

public int findMissing(int[] arr)
{
	int curr = arr[0].getBit(0); //gets 0th bit

	for(int i = 1; i < arr.length; ++i)
	{
		if(arr[i].getBit(0) == curr)
		{
			return i;
		}
		else
		{
			curr = arr[i].getBit(0);
		}
	}
}










