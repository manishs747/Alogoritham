package dynamicProgramming;

public class CountPaths {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	

	//https://www.geeksforgeeks.org/count-possible-paths-top-left-bottom-right-nxm-matrix/
	// Returns count of possible paths to reach  
    // cell at row number m and column number n  
    // from the topmost leftmost cell (cell at 1, 1) 
	
	//2 n 2
    static int  numberOfPaths(boolean [][] grid,int row, int col) {
    	if (!validSquare( grid, row,col)) return 0;
    	if (isAtEnd(grid, row,col))  return 1;
    	return numberOfPaths(grid, row+1, col)+numberOfPaths(grid, row, col+1);
    }
    
    //n 2
    static int  numberOfPathsTopDown(boolean [][] grid,int row, int col ,int [][] path) {
    	if (!validSquare( grid, row,col)) return 0;
    	if (isAtEnd(grid, row,col))  return 1;
    	if (path[row][col] == 0) {
    		path[row][col] = numberOfPathsTopDown(grid, row+1, col, path) + numberOfPathsTopDown(grid, row, col+1, path);
    	}
    	return path[row][col];
    }
    
   

	private static boolean isAtEnd(boolean[][] grid, int row, int col) {
		
		return true;
	}




	private static boolean validSquare(boolean[][] grid, int row, int col) {
		
		return false;
	}

}
