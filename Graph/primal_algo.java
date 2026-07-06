import java.util.*;

class Pair {
    
    int node;
    int distance;

    public Pair(int node, int distance) {
        this.node = node;
        this.distance = distance;
    }
}

class Solution {
    
    public int spanningTree(int V, int[][] edges) {

        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int wt = edge[2];

            adj.get(u).add(new Pair(v, wt));
            adj.get(v).add(new Pair(u, wt));
        }

        PriorityQueue<Pair> pq =
                new PriorityQueue<Pair>((x, y) -> x.distance - y.distance);

        int[] vis = new int[V];

        pq.add(new Pair(0, 0));

        int sum = 0;

        while (pq.size() > 0) {

            int wt = pq.peek().distance;
            int node = pq.peek().node;
            pq.remove();

            if (vis[node] == 1) continue;

            vis[node] = 1;
            sum += wt;

            for (int i = 0; i < adj.get(node).size(); i++) {

                int edw = adj.get(node).get(i).distance;
                int adjnode = adj.get(node).get(i).node;

                if (vis[adjnode] == 0) {
                    pq.add(new Pair(adjnode, edw));
                }
            }
        }

        return sum;
    }
}