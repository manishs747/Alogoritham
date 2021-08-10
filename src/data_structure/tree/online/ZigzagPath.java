package data_structure.tree.online;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * https://leetcode.com/problems/path-in-zigzag-labelled-binary-tree/
 */
public class ZigzagPath {

    public static void main(String[] args) {
        System.out.println(pathInZigZagTree(9));
    }

    public static List<Integer> pathInZigZagTree(int label) {
        List<Integer> list = new ArrayList<>();
        int level = (int) (Math.log(label) / Math.log(2))+1;
        while (level != 0){
            list.add(label);
            int levelmax = ((int)Math.pow(2, level)) - 1;
            int levelmin = (int)Math.pow(2, level-1);
            label = (levelmax + levelmin - label)/2;
            level--;
        }
        Collections.reverse(list);
        return  list;
    }
}
