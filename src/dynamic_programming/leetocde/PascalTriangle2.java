package dynamic_programming.leetocde;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PascalTriangle2 {


    public static void main(String[] args) {
        System.out.println(getRow(3));
    }


    public static List<Integer> getRowBottomUp(int rowIndex) {
        List<Integer> prevList = Arrays.asList(1);
        if(rowIndex == 0) return prevList;
        for (int i = 1; i <= rowIndex ; i++) {
         List current =  new ArrayList<>(prevList.size()+1) ;
            current.add(1);
            for (int j = 1; j < prevList.size() ; j++)
                current.add(prevList.get(j-1)+ prevList.get(j));
            current.add(1);
            prevList = current;
        }
        return prevList;
    }

    public static List<Integer> getRow(int rowIndex) {
        return getRow(rowIndex,Arrays.asList(1));
    }

    public static List<Integer> getRow(int rowIndex,List<Integer> prevList) {
        if(rowIndex == 0) return prevList;
        List current =  new ArrayList<>() ;
        current.add(1);
        for (int j = 1; j < prevList.size() ; j++)
            current.add(prevList.get(j-1)+ prevList.get(j));
        current.add(1);
        return getRow(rowIndex-1,current);
    }





}
