public class MatrixSearch
{
	public static void main(String[] args)
	{
	}

	public static int(int[][] matrix, int key)
	{
		int col = matrix[0].length - 1; 
		int row = 0;

		int numRows = matrix.length;

		while(rows < numRows || col >= 0)
		{
			if(matrix[row][col] == key)
			{
				return matrix[row][col];
			}
			else if(matrix[row][col] > key)
			{
				--col;
			}
			else
			{
				++row;
			}
		}
		return -1;
	}

}
