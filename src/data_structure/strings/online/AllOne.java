package data_structure.strings.online;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/all-oone-data-structure/
 */
public class AllOne {

    public static class Node {
        int freq;
        Node prev;
        Node next;
        Set<String> keys = new HashSet<>();
        Node(int freq) {
            this.freq = freq;
        }
    }

    public static void main(String[] args) {
         // Input
       /* ["AllOne", "inc", "inc", "getMaxKey", "getMinKey", "inc", "getMaxKey", "getMinKey"]
[[], ["hello"], ["hello"], [], [], ["leet"], [], []]

        Output
                [null, null, null, "hello", "hello", null, "hello", "leet"]*/

    }


    public AllOne() {

    }

    public void inc(String key) {

    }

    public void dec(String key) {

    }

    public String getMaxKey() {

        return "";
    }

    public String getMinKey() {

        return "";
    }
}

