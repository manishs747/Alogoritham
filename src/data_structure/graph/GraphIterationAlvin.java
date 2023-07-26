package data_structure.graph;

import java.util.*;


public class GraphIterationAlvin {


    public static void main(String[] args) {
        Map<String, List<String>> graph   = getGraph(); //abdfce
        System.out.println("DFS Iterative ");
        DFSIterative(graph,"a");
        System.out.println("\nDFS Recursive ");
        DFSRecursive(graph,"a");
        System.out.println("\nDFS Iterative ");
        BFSIterative(graph,"a");
    }



    /************************************************************************BFS*****************************************/

    public static void BFSIterative(Map<String, List<String>> graph,String source){
        LinkedList<String> queue = new LinkedList<String>();
        queue.add(source);
        while (!queue.isEmpty()){
            String current = queue.remove();
            System.out.print(current+" ");
            for (String neighbour : graph.get(current)) {
              queue.add(neighbour);
            }
        }
    }


/************************************************************************DFS*****************************************/
    public static void DFSRecursive(Map<String, List<String>> graph,String source){
        System.out.print(source+" ");
        for (String neighbour : graph.get(source)) {
            DFSRecursive(graph, neighbour);
        }
    }


    public static void DFSIterative(Map<String, List<String>> graph,String source){
        Stack<String> stack = new Stack<>();
        stack.add(source);
        while(!stack.isEmpty()){
            String current = stack.pop();
            System.out.print(current+" ");
            for (String neighbour:graph.get(current)) {
                stack.push(neighbour);
            }
        }
    }
    /************************************************************************DFS*****************************************/
    private static Map<String, List<String>> getGraph() {
        Map<String, List<String>> map = new HashMap<>();
        map.put("a", Arrays.asList("c","b"));
        map.put("b", Arrays.asList("d"));
        map.put("c", Arrays.asList("e"));
        map.put("d", Arrays.asList("f"));
        map.put("e", Arrays.asList());
        map.put("f", Arrays.asList());
        return map;
    }


}
