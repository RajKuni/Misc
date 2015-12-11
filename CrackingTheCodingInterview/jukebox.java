a jukebox is composed of a:
-cd player
-display

cd player reads in a cd


Chat server:

-have a central server
-server can accept multiple clients
-each client knows who is online
-clients can keep themselves hidden or exposed to select few
-there is a chat history for each client.


public int fibonacci(int index)
{
	if(n == 0)
	{
		return 0;
	}
	if(n == 1)
	{
		return 1;
	}

	return fibonacci(n - 1) + fibonacci(n - 2);
}

public int numPaths(int[][] n, int x, int y)
{
	
	if(y + 1 >= n.length && x + 1 >= n.length)
	{
		return 0;
	}	
	if(y + 1 >= n.length)
	{
		return numPaths(n, x + 1, y);
	}
	if(x + 1 >= n.length)
	{
		return numPaths(n, x, y + 1);
	}

	return 2 + numPaths(n, x + 1, y) + numPaths(n, x, y + 1); 
}
