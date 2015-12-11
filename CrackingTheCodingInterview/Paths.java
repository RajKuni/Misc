public class Paths
{
	public static void main(String[] args)
	{
		int[][] matrix = {
						  {1,1,1,1},
						  {1,1,1,1},
						  {1,1,1,1},
						  {1,1,1,1}
						 };
		int paths = numPaths(matrix, 0, 0);

		System.out.println(paths);

	}

	public static int numPaths(int[][] n, int x, int y)
	{
	
		if(y + 1 >= n.length && x + 1 >= n.length)
		{
			return 1;
		}	
		if(y + 1 >= n.length)
		{
			return numPaths(n, x + 1, y);
		}
		if(x + 1 >= n.length)
		{
			return numPaths(n, x, y + 1);
		}
	
		return numPaths(n, x + 1, y) + numPaths(n, x, y + 1); 
	}
}
