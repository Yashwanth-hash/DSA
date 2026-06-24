class Solution {

    public int[] shortestPath(int V, int[][] edges, int src) {

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for(int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        for(int i = 0; i < edges.length; i++) {

            int u = edges[i][0];
            int v = edges[i][1];

            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        int[] dist = new int[V];

        for(int i = 0; i < V; i++) {
            dist[i] = (int)1e9;
        }

        dist[src] = 0;

        Queue<Integer> q = new LinkedList<>();
        q.add(src);

        while(!q.isEmpty()) {

            int node = q.poll();

            for(int it : adj.get(node)) {

                if(dist[node] + 1 < dist[it]) {

                    dist[it] = dist[node] + 1;
                    q.add(it);
                }
            }
        }

        for(int i = 0; i < V; i++) {

            if(dist[i] == (int)1e9) {
                dist[i] = -1;
            }
        }

        return dist;
    }
}
