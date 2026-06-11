import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Course_schedule {
    public boolean canFinish(int v, int[][] prerequisites) {
        
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0;i<v;i++){
            adj.add(new ArrayList<>());
        }

        int m=prerequisites.length;

        for(int i=0;i<m;i++){
            adj.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }

        int indegree [] = new int[v];
        for(int i=0;i<v;i++){
            for(int it: adj.get(i)){
                indegree[it]++;
            }
        }
        Queue<Integer> q = new LinkedList<Integer>();

        for(int i=0;i<v;i++){
            if(indegree[i] == 0){
                q.add(i);
            }
        }
        List<Integer> topo = new ArrayList<Integer>();
        //(v+e)
        while(!q.isEmpty()){
            int node = q.peek();
            q.remove();
            topo.add(node);


            for(int it: adj.get(node)){
                indegree[it]--;
                if(indegree[it]==0) q.add(it);
            }
        }
        if(topo.size() == v ) return true;

        return false;
    }
}
