public class Detectcycle_directed_graph {
    
    private boolean dfscheck(int node,ArrayList<ArrayList<Integer>> adj,int vis[],int pathvis[]){

        vis[node] =1;
        pathvis[node] =1;

        for(int it: adj.get(node)){
            if(vis[it]==0){
                if(dfscheck(it,adj,vis,pathvis)==true)
                    return true;
            }
            else if(pathvis[it]==1){
                return true;
            }
        }

        pathvis[node] =0;
        return false;
    }
    public boolean iscyclic(int v,ArrayList<ArrayList<Integer>> adj){
        int vis[] = new int[v];
        int pathvis[] = new int[v];

        for(int i=0;i<v;i++){
            if(vis[i]==0){
                if(dfscheck(i,adj,vis,pathvis)==true) return true;
            }
        }
        return false;
    }
}
