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

    public List<Integer> shortestPath(int n, int m, int[][] edges) {

        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }

        // Build adjacency list
        for (int i = 0; i < m; i++) {

            int u = edges[i][0];
            int v = edges[i][1];
            int wt = edges[i][2];

            adj.get(u).add(new Pair(wt, v));
            adj.get(v).add(new Pair(wt, u));
        }

        PriorityQueue<Pair> pq =
                new PriorityQueue<>((x, y) -> x.distance - y.distance);

        int[] dist = new int[n + 1];
        int[] parent = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            dist[i] = (int)1e9;
            parent[i] = i;
        }

        dist[1] = 0;
        pq.add(new Pair(0, 1));

        while (!pq.isEmpty()) {

            Pair curr = pq.poll();

            int dis = curr.distance;
            int node = curr.node;

            for (Pair it : adj.get(node)) {

                int adjNode = it.node;
                int edgeWeight = it.distance;

                if (dis + edgeWeight < dist[adjNode]) {

                    dist[adjNode] = dis + edgeWeight;

                    parent[adjNode] = node;

                    pq.add(new Pair(dist[adjNode], adjNode));
                }
            }
        }

        List<Integer> path = new ArrayList<>();

        if (dist[n] == (int)1e9) {
            path.add(-1);
            return path;
        }

        int node = n;

        while (parent[node] != node) {
            path.add(node);
            node = parent[node];
        }

        path.add(1);

        Collections.reverse(path);

        // Add total distance at the beginning
        path.add(0, dist[n]);

        return path;
    }
}