package data_structure.graph.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FindSmallestSetOfVertices {

    public static void main(String[] args) {

    }
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i <n ; i++)
            set.add(i);
        Set<Integer> destinationSet = new HashSet<>();
        for (List<Integer> edge:edges)
            destinationSet.add(edge.get(1));
        set.removeAll(destinationSet);
        return new ArrayList<>(set);
    }

    public List<Integer> findSmallestSetOfVertices2(int n, List<List<Integer>> edges) {
        ArrayList<Integer> result = new ArrayList<>();
        int [] nodes = new int[n];
        for (List<Integer> edge:edges)
            nodes[edge.get(1)] = 1;
        for (int i = 0; i <n ; i++)
            if(nodes[i] == 0)  result.add(i);
        return result;
    }

    public List<Integer> findSmallestSetOfVertices3(int n, List<List<Integer>> edges) {
        Set<Integer> nodesWithIncomingEdges = new HashSet<>();
        for (List<Integer> edge : edges)
            nodesWithIncomingEdges.add(edge.get(1));
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (!nodesWithIncomingEdges.contains(i))
                result.add(i);
        }
        return result;
    }

}
