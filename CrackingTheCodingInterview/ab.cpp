//Compile String
//
//cl -Z7 /EHsc ab.cpp /link -PDB:ab.pdb



#include <string>
#include <iostream>
using namespace std;


class AB
{
	
	public:
		string createString(int, int);
};

string AB::createString(int n, int k)
{
	char *buffer = new char[n];

	for(int i = 0; i < n/2; ++i)
	{
		*(buffer + i) = 'B';
	}

	for(int i = n/2; i < n; ++i)
	{
		*(buffer + i) = 'A';
	}
	
	int pairs = 0;
	
	while(true)
	{
		int curr = -1;

		for(int i = 0; i < n - 1; ++i)
		{
			if(pairs == k)
			{
				string result = string(buffer);
				return result;
			}

			if(*(buffer + i) == 'B' && *(buffer + i + 1) == 'A')
			{
				++pairs;
				curr = i;
				*(buffer + i) = 'A';
				*(buffer + i + 1) = 'B';
			}
		}

		if(curr == -1)
		{
			break;
		}

	}

	return "";

}

int main()
{
	AB* myAB = new AB();

	string result = myAB->createString(10, 12);

	cout << "Ans: " << result << "\n";
}


