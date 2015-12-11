import java.util.*;

public class Queens
{
	public static void main(String[] args)
	{
		int boardSize = Integer.parseInt(args[0]);
		generateBoards(boardSize);
	}

	public static void generateBoards(int dim)
	{
		int[] rowPlace = new int[dim];

		for(int i = 0; i < rowPlace.length; ++i)
		{
			rowPlace[i] = -1;
		}

		generateBoards(rowPlace, 0);
	}

	public static void generateBoards(int[] rowPlace, int column)
	{
		if(column == rowPlace.length)
		{
			printBoard(rowPlace);
			System.out.println(" / / / / / / / / / ");
			return;
		}

		
		while(rowPlace[column] < rowPlace.length)
		{
			boolean free = check(column, rowPlace);
			if(free)
			{
				generateBoards(rowPlace, column + 1); //go to next column to place next queen
			}
		}
		rowPlace[column] = -1; //reset this queen to -1. We are going to reposition once previous queens have been reset	
	}

	public static boolean check(int column, int[] queenPlacements)
	{
		queenPlacements[column]++; //always increment from previous value
		int curRow = queenPlacements[column];

		for(int i = curRow; i < queenPlacements.length; ++i)
		{
			boolean free = check(column, i, queenPlacements);
			if(free)
			{
				return free;
			}
		}
		queenPlacements[column] = queenPlacements.length;
		return false;
	}

	public static boolean check(int columnQueen, int rowToPlaceIn, int[] queenPlacements)
	{
		queenPlacements[columnQueen] = rowToPlaceIn; //set row of this queen
		
		int dim = queenPlacements.length;

		//now check if new placement conflicts with restrictions
		for(int i = columnQueen - 1; i >= 0; --i)
		{
			if(queenPlacements[columnQueen] == queenPlacements[i]) //same row
			{
				return false;
			}
			
			//if the row and column difference of the compared queens are the same, they share a diagonal
			int colDifference = Math.abs(columnQueen - i);
			int rowDifference = Math.abs(queenPlacements[columnQueen] - queenPlacements[i]); 

			if(colDifference == rowDifference)
			{
				return false;
			}
		}		
		return true;
	}

	public static void printBoard(int[] qPlaces)
	{
		int dim = qPlaces.length;
		int[][] board = new int[dim][dim];

		for(int col = 0; col < dim; ++col)
		{
			board[qPlaces[col]][col] = 1;
		}

		//print board out;
		for(int i = 0; i < dim; ++i)
		{
			for(int j = 0; j < dim; ++j)
			{
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}
	}
}


