package graphs;

import java.util.*;

/**
 * Dijkstra's Single Source Shortest Path Algorithm.
 * Greedy algorithm using PriorityQueue (Min-Heap).
 * Time: O((V + E) log V) | Space: O(V)
 * 
 * @author CodeByTushu
 */
public class DijkstraShortestPath {

    public static class Edge {
        int target;
        int weight;
        public Edge(int target, int weight) {
            this.target = target;
            this.weight = weight;
        }
    }

    public static class NodePair implements Comparable<NodePair> {
        int node;
        int distance;
        public NodePair(int node, int distance) {
            this.node = node;
            this.distance = distance;
        }
        @Override
        public int compareTo(NodePair other) {
            return Integer.compare(this.distance, other.distance);
        }
    }

    public static int[] dijkstra(int numVertices, List<List<Edge>> graph, int source) {
        int[] dist = new int[numVertices];
        Arrays.fill(dist, Integer.MAX_VALUE);
        PriorityQueue<NodePair> pq = new PriorityQueue<>();

        dist[source] = 0;
        pq.offer(new NodePair(source, 0));

        while (!pq.isEmpty()) {
            NodePair current = pq.poll();
            int u = current.node;
            int d = current.distance;

            if (d > dist[u]) continue;

            for (Edge edge : graph.get(u)) {
                int v = edge.target;
                int weight = edge.weight;

                if (dist[u] + weight < dist[v]) {
                    dist[v] = dist[u] + weight;
                    pq.offer(new NodePair(v, dist[v]));
                }
            }
        }
        return dist;
    }

    public static void main(String[] args) {
        int v = 5;
        List<List<Edge>> graph = new ArrayList<>();
        for (int i = 0; i < v; i++) graph.add(new ArrayList<>());

        graph.get(0).add(new Edge(1, 4));
        graph.get(0).add(new Edge(2, 1));
        graph.get(2).add(new Edge(1, 2));
        graph.get(1).add(new Edge(3, 1));
        graph.get(2).add(new Edge(3, 5));
        graph.get(3).add(new Edge(4, 3));

        int[] shortest = dijkstra(v, graph, 0);
        System.out.println("Shortest distances from node 0: " + Arrays.toString(shortest));
    }
}
