package dynamic_programming.leetocde;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/pascals-triangle/description/?envType=problem-list-v2&envId=dynamic-programming&difficulty=EASY
 */
public class PascalTriangle {

    public static void main(String[] args) {
        System.out.println(generateTop(2));
    }

    public static List<List<Integer>> generateTop(int numRows) {
        if(numRows == 1) return Arrays.asList(Arrays.asList(1));
        List<List<Integer>> prevResult = generateTop(numRows - 1);
        for (int i = 0; i < numRows ; i++) {
            ArrayList<Integer> list = new ArrayList<>();
            for (int j = 0; j <= i ; j++) {
                if(j == 0 || j == i){
                    list.add(1);
                }else{
                    List<Integer> prevList = prevResult.get(i-1);
                    list.add(prevList.get(j) + prevList.get(j-1));
                }
            }
            prevResult.add(list);
        }

        return prevResult;
    }




    /**
     * Bottom Up Approch
     * @param numRows
     * @return
     */
    public static List<List<Integer>> generateBottom(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < numRows ; i++) {
           List<Integer> list = new ArrayList<>();
            for (int j = 0; j <= i ; j++) {
                  if(j == 0 || j == i){
                      list.add(1);
                  }else{
                      List<Integer> prevList = result.get(i-1);
                      list.add(prevList.get(j) + prevList.get(j-1));
                  }
            }
           result.add(list);
        }
        return result;
    }

    public static List<List<Integer>> generateBottom2(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        if(numRows == 0) return result;
        result.add(new ArrayList<>(){{add(1);}});
       for (int i = 1; i < numRows ; i++) {
            List<Integer> list = new ArrayList<>(){{add(1);}};
            for (int j = 1; j < i ; j++) {
                    List<Integer> prevList = result.get(i-1);
                    list.add(prevList.get(j) + prevList.get(j-1));
            }
            list.add(1);
            result.add(list);
        }
        return result;
    }
}
