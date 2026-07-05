import java.util.*;

class Pair {
    int node;
    long distance;

    Pair(int node, long distance) {
        this.node = node;
        this.distance = distance;
    }
}

class Solution {

    public int countPaths(int n, int[][] roads) {

        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        // Build undirected weighted graph
        for (int i = 0; i < roads.length; i++) {

            int u = roads[i][0];
            int v = roads[i][1];
            int time = roads[i][2];

            adj.get(u).add(new Pair(v, time));
            adj.get(v).add(new Pair(u, time));
        }

        PriorityQueue<Pair> pq =
                new PriorityQueue<>((x, y) -> Long.compare(x.distance, y.distance));

        long[] dist = new long[n];
        int[] ways = new int[n];

        Arrays.fill(dist, Long.MAX_VALUE);

        dist[0] = 0;
        ways[0] = 1;

        pq.add(new Pair(0, 0));

        int mod = (int) 1e9 + 7;

        while (!pq.isEmpty()) {

            Pair curr = pq.poll();

            int node = curr.node;
            long dis = curr.distance;

            // Ignore an old/outdated entry in the priority queue
            if (dis > dist[node]) {
                continue;
            }

            for (Pair it : adj.get(node)) {

                int adjNode = it.node;
                long edgeWeight = it.distance;

                // Found a strictly shorter path
                if (dis + edgeWeight < dist[adjNode]) {

                    dist[adjNode] = dis + edgeWeight;
                    ways[adjNode] = ways[node];

                    pq.add(new Pair(adjNode, dist[adjNode]));
                }

                // Found another path with the same shortest distance
                else if (dis + edgeWeight == dist[adjNode]) {

                    ways[adjNode] = (ways[adjNode] + ways[node]) % mod;
                }
            }
        }

        return ways[n - 1];
    }
}