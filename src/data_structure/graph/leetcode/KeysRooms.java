package data_structure.graph.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class KeysRooms {

    public static void main(String[] args) {

    }

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int numRooms = rooms.size();
        boolean[] visited = new boolean[numRooms];
        dfs(rooms, 0, visited);
        for (boolean roomVisited : visited) {
            if (!roomVisited) return false;
        }
        return true;
    }

    private static void dfs(List<List<Integer>> rooms, int room, boolean[] visited) {
        visited[room] = true;
        for (int key : rooms.get(room)) {
            if (!visited[key]) {
                dfs(rooms, key, visited);
            }
        }
    }

    /*******************************************v1***********************************/
    public boolean canVisitAllRooms1(List<List<Integer>> rooms) {
        Set<Integer> nonOpenedRooms = new HashSet<>();
        for (int i = 0; i < rooms.size() ; i++) nonOpenedRooms.add(i);
        dfs(rooms,nonOpenedRooms, Arrays.asList(0));
        return nonOpenedRooms.isEmpty();
    }

    private static void dfs(List<List<Integer>> rooms, Set<Integer> nonOpenedRooms, List<Integer> keys) {
        for (int key:keys) {
            if(!nonOpenedRooms.contains(key)) continue;
            nonOpenedRooms.remove(key);
            dfs(rooms,nonOpenedRooms,rooms.get(key));
        }
    }
}
