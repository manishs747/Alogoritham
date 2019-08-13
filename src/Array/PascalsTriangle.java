package Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;



public class PascalsTriangle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(getRow(3));

	}
	
	
	/*
	 * 
	 * https://leetcode.com/problems/pascals-triangle/
	 * 
	 * Input: 5
Output:
[
     [1],
    [1,1],
   [1,2,1],
  [1,3,3,1],
 [1,4,6,4,1]
]
	 */
	
	public static  List<List<Integer>> generate(int numRows) {
		List<List<Integer>> result = new ArrayList<>();
		List<Integer> e = new ArrayList<>();
		e.add(1);
		result.add(e );
		for (int i = 1; i < numRows; i++) {
			List<Integer> current = Arrays.asList(new Integer[i+1]);
			int first = 0;
			int last = i ;
			current.set(first, 1);
			current.set(last, 1);
			System.out.println("Adding last elelmt :"+last+" size:"+current.size());
			List<Integer>  prev = result.get(i-1);
			for (int j = first+1; j < last; j++) {
				Integer element = prev.get(j) + prev.get(j-1);
				current.set(j, element );
			}
			result.add(current);
		}
		return result;
	}
	/*
	 * Input: 3
Output: [1,3,3,1]
	 */
	 public static List<Integer> getRow(int rowIndex) {
		 List<Integer> prev = new ArrayList<>(rowIndex+1);
		 List<Integer> current = new ArrayList<>(rowIndex+1);
		 List<Integer> tmp  = null;
		 prev.add(1);
		 current.add( 1);
		 for(int i = 1;i <= rowIndex;i++ ) {
			 for (int j = 1; j < i; j++) {
				 current.set(j,prev.get(j)+prev.get(j-1));
			}
			 current.add(1);
			 tmp = prev;
			 prev = current;
			 current = tmp;
			 current.add(0);
		 }
		 return prev;
	    }
	 
	   public List<Integer> getRowleet(int rowIndex) {
	        if (rowIndex < 0) {
	            throw new IllegalArgumentException();
	        }
	        List<Integer> lastRowList = Arrays.asList(1);
	        for (int row = 1; row <= rowIndex; row++) {
	            List<Integer> rowList = new ArrayList<>();
	            rowList.add(1);
	            for (int i = 0; i < lastRowList.size() - 1; i++) {
	                rowList.add(lastRowList.get(i) + lastRowList.get(i + 1));
	            }
	            rowList.add(1);
	            lastRowList = rowList;
	        }
	        return lastRowList;
	    }
	 
	
	 public List<List<Integer>> generateLeetCode(int numRows) {
	        List<List<Integer>> triangle = new ArrayList<List<Integer>>();

	        // First base case; if user requests zero rows, they get zero rows.
	        if (numRows == 0) {
	            return triangle;
	        }

	        // Second base case; first row is always [1].
	        triangle.add(new ArrayList<>());
	        triangle.get(0).add(1);

	        for (int rowNum = 1; rowNum < numRows; rowNum++) {
	            List<Integer> row = new ArrayList<>();
	            List<Integer> prevRow = triangle.get(rowNum-1);

	            // The first row element is always 1.
	            row.add(1);

	            // Each triangle element (other than the first and last of each row)
	            // is equal to the sum of the elements above-and-to-the-left and
	            // above-and-to-the-right.
	            for (int j = 1; j < rowNum; j++) {
	                row.add(prevRow.get(j-1) + prevRow.get(j));
	            }

	            // The last row element is always 1.
	            row.add(1);

	            triangle.add(row);
	        }

	        return triangle;
	    }

}
