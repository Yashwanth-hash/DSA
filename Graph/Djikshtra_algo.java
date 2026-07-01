import java.util.*;

class Pair {
    int distance;
    int node;

    Pair(int distance, int node) {
        this.distance = distance;
        this.node = node;
    }
}

class Solution {

    public int[] dijkstra(int V, int[][] edges, int src) {

        // Create adjacency list
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        // Build graph (Undirected)
        for (int[] edge : edges) {

            int u = edge[0];
            int v = edge[1];
            int wt = edge[2];

            adj.get(u).add(new Pair(wt, v));
            adj.get(v).add(new Pair(wt, u));
        }

        // Min Heap
        PriorityQueue<Pair> pq =
                new PriorityQueue<>((x, y) -> x.distance - y.distance);

        int[] dist = new int[V];

        Arrays.fill(dist, (int)1e9);

        dist[src] = 0;

        pq.add(new Pair(0, src));

        while (!pq.isEmpty()) {

            Pair curr = pq.poll();

            int dis = curr.distance;
            int node = curr.node;

            for (Pair it : adj.get(node)) {

                int edgeWeight = it.distance;
                int adjNode = it.node;

                if (dis + edgeWeight < dist[adjNode]) {

                    dist[adjNode] = dis + edgeWeight;

                    pq.add(new Pair(dist[adjNode], adjNode));
                }
            }
        }

        return dist;
    }
}