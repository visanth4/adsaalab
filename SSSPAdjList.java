import java.util.*;

// Class to represent an edge
class Edge {
    int to, weight;
    Edge(int to, int weight) {
        this.to = to;
        this.weight = weight;
    }
}

public class SSSPAdjList {

    static void dijkstra(List<Edge>[] graph, int source) {
        int n = graph.length;
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[source] = 0;

        // Min-heap priority queue to always pick vertex with smallest distance
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        pq.add(new int[]{source, 0}); // {vertex, distance}

        boolean[] visited = new boolean[n];

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int u = curr[0];

            if (visited[u]) continue;
            visited[u] = true;

            for (Edge e : graph[u]) {
                int v = e.to;
                int w = e.weight;

                if (!visited[v] && dist[u] + w < dist[v]) {
                    dist[v] = dist[u] + w;
                    pq.add(new int[]{v, dist[v]});
                }
            }
        }

        // Print distances
        System.out.println("Vertex \t Distance from Source");
        for (int i = 0; i < n; i++) {
            System.out.println(i + "\t\t" + dist[i]);
        }
    }

    public static void main(String[] args) {
        int n = 4; // number of vertices
        List<Edge>[] graph = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        // Add edges (directed graph)
        graph[0].add(new Edge(1, 2));
        graph[0].add(new Edge(2, 4));
        graph[1].add(new Edge(2, 1));
        graph[1].add(new Edge(3, 7));
        graph[2].add(new Edge(3, 3));

        dijkstra(graph, 0); // source vertex = 0
    }
}
