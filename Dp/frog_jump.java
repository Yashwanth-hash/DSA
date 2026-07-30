package Dp;
// memoization is done to

import java.util.Arrays;

public class frog_jump {
     public int f(int index,int[] h,int [] dp){
    if(index == 0) return 0;
    if(dp[index]!=-1){
        return dp[index];
    }
    int left = f(index-1,h,dp) + Math.abs(h[index]-h[index-1]);
    int right = Integer.MAX_VALUE;
    if(index>1) { right = f(index-2,h,dp) + Math.abs(h[index]-h[index-2]);}
    
    dp[index] = Math.min(left,right);
    return dp[index];
}
    int minCost(int[] height) {
        int n = height.length;
        int [] dp = new int[n+1];
        Arrays.fill(dp,-1);
        return f(n - 1, height,dp);
        
    }
}
