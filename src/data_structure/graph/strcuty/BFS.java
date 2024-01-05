package data_structure.graph.strcuty;

import data_structure.graph.Utility;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class BFS {

    public static void main(String[] args) {
        Map<String, List<String>> graph = Utility.getSampleGraph();
        System.out.println(graph);
        BFS(graph,"i");
        System.out.println("***************************");

    }


    public static void BFS(Map<String, List<String>> graph,String source){
        Queue<String> queue = new LinkedList<>();
        queue.add(source);
        while (!queue.isEmpty()){
            String current = queue.poll();
            System.out.println(current);
            for (String child:graph.get(current)) {
                queue.add(child);
            }

        }
    }
}
