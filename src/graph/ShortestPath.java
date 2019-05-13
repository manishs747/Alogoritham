package graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

import graph.Graph;

public class ShortestPath {

	private Node [] nodes;
	private static int EDGE_DISTANGE =  6;

	public ShortestPath(int size ) {
		EDGE_DISTANGE = size;
	}
	
	//bfs
	public int[] shortestReach(int startId) {
		Queue<Integer> queue = new LinkedList<Integer>();	
		queue.add(startId);
		
		int [] distances = new int [nodes.length];
		Arrays.fill(distances,-1);
		distances[startId] = 0;
		
		while(!queue.isEmpty()) {
			int node  = queue.poll();
			for(Node neighbour  : nodes[node].adjacent) {
				if (distances[neighbour.id]  == -1) { //not visited
					distances[neighbour.id] = distances[node] + EDGE_DISTANGE;
					queue.add(neighbour.id);
				}
			}
		}
		return distances;
	}

}
