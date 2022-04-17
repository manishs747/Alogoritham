package data_structure.arrays.online;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/design-an-ordered-stream/
 */
public class OrderSystem {

    List<String> list ;

    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>(5);
        list.add("abc");

    }

    public OrderSystem(int n) {
        list = new ArrayList<>(n);
        for (int i = 0; i < n ; i++) {
            list.add("");
        }
    }

    public List<String> insert(int idKey, String value) {
        list.add(idKey,value);
        return list;
    }
}
