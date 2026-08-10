import java.util.*;

class Solution {

    int f(int i,int j,List<List<Integer>> tr , int [][] dp){
        int n = tr.size();
        if(i == n-1) return tr.get(i).get(j);
        if(dp[i][j]!=Integer.MAX_VALUE) return dp[i][j];

        int d = tr.get(i).get(j) +f(i+1,j,tr,dp);
        int dg = tr.get(i).get(j) + f(i+1,j+1,tr,dp);

        dp[i][j] = Math.min(d,dg);

        return dp[i][j];
    }
    public int minimumTotal(List<List<Integer>> triangle) {
        
        int m = triangle.size();

        int [][] dp = new int[m][m];

        for(int i=0;i<m;i++){
            Arrays.fill(dp[i],Integer.MAX_VALUE);
        }

        return f(0,0,triangle,dp);

    }
}
