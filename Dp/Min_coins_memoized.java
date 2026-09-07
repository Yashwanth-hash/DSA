import java.util.*;

class Solution {

    public int f(int ind, int target, int arr[],int dp[][]) {

        if(ind == 0) {
            if(target % arr[ind] == 0)
                return target / arr[ind];
            else
                return (int)1e9;
        }
        if(dp[ind][target]!=-1) return dp[ind][target];
        int notTake = 0 + f(ind - 1, target, arr,dp);

        int take = (int)1e9;

        if(arr[ind] <= target)
            take = 1 + f(ind, target - arr[ind], arr,dp);

        dp[ind][target] = Math.min(take, notTake);
        return dp[ind][target];
    }

    public int coinChange(int[] coins, int amount) {

        int n = coins.length;
        int dp[][] = new int[n][amount+1];

        for(int i=0;i<n;i++){
                    Arrays.fill(dp[i],-1);

        }
        int ans = f(n - 1, amount, coins,dp);

        if(ans >= (int)1e9)
            return -1;

        return ans;
    }
}