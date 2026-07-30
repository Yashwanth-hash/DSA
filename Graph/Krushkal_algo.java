import java.util.*;

class DisjointSet{
    
    List<Integer> parent = new ArrayList<>();
    List<Integer> size  = new ArrayList<>();
    
    public DisjointSet(int n){
        
        for(int i=0;i<=n;i++){
            parent.add(i);
            size.add(1);
        }
    }
    
    public int findUPar(int node){
        if(node == parent.get(node)){
            return node;
        }
        
        int ulp = findUPar(parent.get(node));
        parent.set(node,ulp);
        return parent.get(node);
    }
    
    public void unionBySize(int u,int v){
        int ulp_u = findUPar(u);
        int ulp_v = findUPar(v);
        
        if(ulp_u == ulp_v) return;
        
        if(size.get(ulp_u) < size.get(ulp_v)){
            
            parent.set(ulp_u,ulp_v);
            size.set(ulp_v,size.get(ulp_v)+size.get(ulp_u));
        }
        else{
             parent.set(ulp_v, ulp_u);
            size.set(ulp_u, size.get(ulp_u) + size.get(ulp_v));
        }
    }
}

class Edge{
    int wt,u,v;
    
    Edge(int wt, int u, int v) {
        this.wt = wt;
        this.u = u;
        this.v = v;
    }
}
class Solution {
    public int spanningTree(int V, int[][] edges) {
        
        List<Edge> edgeList = new ArrayList<>();
        // M + E
        for(int [] edge : edges){
            int u =edge[0];
            int v = edge[1];
            int wt = edge[2];
            
            edgeList.add(new Edge(wt,u,v));
        }
        //M logM
        Collections.sort(edgeList,(a,b) -> a.wt-b.wt);
        
        DisjointSet ds = new DisjointSet(V);
        
        int mstWeight =0;
        // M * 4 * alpha
        for(Edge it: edgeList){
            int wt = it.wt;
            int u = it.u;
            int v = it.v;
            
            if(ds.findUPar(u) != ds.findUPar(v)){
                mstWeight += wt;
                ds.unionBySize(u,v);
            }
        }
        return mstWeight;
    }
}

