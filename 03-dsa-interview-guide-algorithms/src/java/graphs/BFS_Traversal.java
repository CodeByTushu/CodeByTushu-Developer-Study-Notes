package graphs;

import java.util.*;

/**
 * Breadth-First Search (BFS) on Graph.
 * Level-by-level traversal using Queue.
 * Time: O(V + E) | Space: O(V)
 * 
 * @author CodeByTushu
 */
public class BFS_Traversal {

    public static List<Integer> bfsOfGraph(int numVertices, List<List<Integer>> adjList) {
        List<Integer> bfsResult = new ArrayList<>();
        boolean[] visited = new boolean[numVertices];
        Queue<Integer> queue = new LinkedList<>();

        // Starting from vertex 0
        visited[0] = true;
        queue.offer(0);

        while (!queue.isEmpty()) {
            int current = queue.poll();
            bfsResult.add(current);

            for (int neighbor : adjList.get(current)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.offer(neighbor);
                }
            }
        }
        return bfsResult;
    }

    public static void main(String[] args) {
        int v = 5;
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < v; i++) adj.add(new ArrayList<>());

        adj.get(0).addAll(Arrays.asList(1, 2, 3));
        adj.get(2).add(4);

        System.out.println("BFS Traversal: " + bfsOfGraph(v, adj));
    }
}
