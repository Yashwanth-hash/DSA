import java.util.*;

class Pair {

    int distance;
    int node;

    Pair(int d, int n) {
        distance = d;
        node = n;
    }
}

class Solution {

    public List<Integer> shortestPath(int n, int m, int edges[][]) {

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
            dist[i] = (int) 1e9;
            parent[i] = i;
        }

        dist[1] = 0;
        pq.add(new Pair(0, 1));

        while (!pq.isEmpty()) {

            Pair it = pq.poll();

            int node = it.node;
            int dis = it.distance;

            for (Pair iter : adj.get(node)) {

                int adjNode = iter.node;
                int edgeWeight = iter.distance;

                if (dis + edgeWeight < dist[adjNode]) {

                    dist[adjNode] = dis + edgeWeight;

                    pq.add(new Pair(dist[adjNode], adjNode));

                    parent[adjNode] = node;
                }
            }
        }

        List<Integer> path = new ArrayList<>();

        if (dist[n] == (int) 1e9) {
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

        return path;
    }
}