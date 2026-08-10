import java.util.*;

class Solution {

    
    public int minPathSum(int[][] grid) {
        
        int m = grid.length;
        int n = grid[0].length;

        int [][] dp = new int[m][n];

        for(int i=0;i<m;i++){
            Arrays.fill(dp[i],-1);
        }

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                int up=1000000000;
                int left=1000000000;
                if(i==0 && j==0) dp[i][j] = grid[0][0];
            
            else{
                if(i>0) up = grid[i][j] +dp[i-1][j];
                if(j>0)  left = grid[i][j] +dp[i][j-1];

                dp[i][j] = Math.min(left,up);
            }
            
            }
        }
        return dp[m-1][n-1];

    }
}