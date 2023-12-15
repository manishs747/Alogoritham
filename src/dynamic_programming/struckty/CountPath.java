package dynamic_programming.struckty;

import java.util.List;

public class CountPath {

    public static void main(String[] args) {
        List<List<String>> grid = List.of(
                List.of("O", "O", "X"),
                List.of("O", "O", "O"),
                List.of("O", "O", "O")
        );
        System.out.println(countPaths(grid));
    }

    public static int countPaths(List<List<String>> grid) {
        int rows = grid.size();
        int cols = grid.get(0).size();
        Integer[][] memo = new Integer[rows][cols];
        return countPaths(0,0,grid.size(),grid.get(0).size(),grid,memo);
    }
    public static int countPaths(int r,int c,int R,int C,List<List<String>> grid,Integer[][] memo) {
          if(isInvalid(r,c,R,C,grid)) return 0;
          if(isEnd(r,c,R,C,grid)) return 1;
          if(memo[r][c] != null) return memo[r][c];
          return memo[r][c] =  countPaths(r+1,c,R,C,grid ,memo) + countPaths(r,c+1,R,C,grid ,memo);
    }

    private static boolean isInvalid(int r, int c, int R, int C, List<List<String>> grid) {
        return r >= R || c >= C || grid.get(r).get(c).equals("X");
    }

    private static boolean isEnd(int r, int c, int R, int C, List<List<String>> grid) {
        return r == R-1 && c == C-1;
    }
}
