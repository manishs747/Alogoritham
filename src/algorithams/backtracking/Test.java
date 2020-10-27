package algorithams.backtracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test {

    public static void main(String[] args) {

        int mat[][] = {
                {1,0,0},
                {0,0,1},
                {1,0,0},
        };
        System.out.println(numSpecial(mat));

    }

   static class Pair{
        int row;
        int col;
        Pair(int row,int col){
            this.col =  col;
            this.row =  row;
        }
        public int getRow() {
            return row;
        }
        public int getCol() {
            return col;
        }
    }


    public static int numSpecial(int[][] mat) {
        Map<Integer,Integer> rowMap = new HashMap<>();
        Map<Integer,Integer> colMap = new HashMap<>();
        int row = mat.length;
        int col = mat[0].length;
        List<Pair> list = new ArrayList<>();

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if(mat[i][j] == 1){
                   if(rowMap.containsKey(i) ){
                       rowMap.put(i,2);
                   }else{
                       rowMap.put(i,1);
                   }
                    if(colMap.containsKey(j) ){
                        colMap.put(j,2);
                    }else{
                        colMap.put(j,1);
                    }
                    list.add(new Pair(i,j));
                }
            }
        }
        System.out.println(rowMap);
        System.out.println(colMap);
        int result = 0;
        for (Pair p:list) {
            if(rowMap.get(p.getRow()) == 1 && colMap.get(p.getCol()) ==  1){
                result++;
            }

        }
        return result;
    }


}


