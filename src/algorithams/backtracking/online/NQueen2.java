package algorithams.backtracking.online;


import java.util.*;

/**
 * https://leetcode.com/problems/n-queens-ii/description/?envType=problem-list-v2&envId=backtracking
 */
public class NQueen2 {

    public static void main(String[] args) {
        System.out.println(totalNQueens(4));
    }

    public static int totalNQueens(int n) {
        Set<List<String>> result = new HashSet<>();
        solveNQueens(n,new ArrayList<>(), new HashSet<>(),new HashSet<>() ,new HashSet<>(),result);
        return result.size();
    }

    public static void solveNQueens(int n , List<Integer> memo , Set<Integer> colset, Set<Integer> diag1 , Set<Integer> diag2 , Set<List<String>> result) {
        if(memo.size() == n){
            result.add(format(memo));
            return;
        }
        for (int i = 0; i < n ; i++) {
            int row = memo.size(), col = i;
            if (colset.contains(col) || diag1.contains(row - col) || diag2.contains(row + col)) {
                continue;
            }
            colset.add(col);
            diag1.add(row-col);
            diag2.add(row+col);
            memo.add(i);
            solveNQueens(n,memo,colset,diag1,diag2,result);
            memo.remove(memo.size()-1);
            colset.remove(col);
            diag1.remove(row-col);
            diag2.remove(row+col);
        }
    }


    public static List<String> format(List<Integer> arr){
        List<String> result = new ArrayList<>();
        for (int n:arr) {
            char[] car = new char[arr.size()];
            Arrays.fill(car, '.');
            car[n] = 'Q';
            result.add(new String(car));
        }
        return  result;
    }
}
