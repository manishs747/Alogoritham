package data_structure.graph.strcuty;

import algorithams.sorting.Sort;
import data_structure.graph.Utility;

import java.util.List;
import java.util.Map;
import java.util.Stack;

public class DFS {

    public static void main(String[] args) {
        Map<String, List<String>> graph = Utility.getSampleGraph();
        System.out.println(graph);
        dfsIterative(graph,"i");
        System.out.println("***************************");
        DFS(graph,"i");
    }


    public static  void DFS(Map<String, List<String>> graph,String source){
        System.out.println(source);
        for (String child:graph.get(source)) {
            DFS(graph,child);
        }
    }

    public static void dfsIterative(Map<String, List<String>> graph,String source){
           Stack<String> stack = new Stack<>();
           stack.add(source);
           while (!stack.isEmpty()){
             String  current = stack.pop();
             System.out.println(current);
               for (String child:graph.get(current)) {
                   stack.add(child);
               }
           }
    }


}
