

class Solution {

  

    public int coinChange(int[] coins, int amount) {

        int n = coins.length;
        int dp[][] = new int[n][amount+1];

        for(int i=0;i<n;i++){
                    Arrays.fill(dp[i],0);

        }
        
        for(int T=0;T<=amount;T++){
            if(T%coins[0]==0) dp[0][T] = T/coins[0];
            else dp[0][T] = (int)1e9;
        }

        for(int ind=1;ind<n;ind++){
            for(int j =0;j<=amount;j++){
                
        int notTake = 0 + dp[ind - 1][j];
        int take = (int)1e9;

        if(coins[ind] <= j)
            take = 1 + dp[ind][j-coins[ind]];

        dp[ind][j] = Math.min(take, notTake);
       
            }
        }

        int ans = dp[n-1][amount];
        if(ans>=(int)1e9) return -1;
        else 
        return ans;
    }
} 