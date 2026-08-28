class Solution {

    

    static boolean isSubsetSum(int arr[], int sum) {

        int n = arr.length;

        boolean dp[][] = new boolean[n][sum + 1];

        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], false);
        }
        
       for(int i=0;i<n;i++) dp[i][0] = true;
       dp[0][arr[0]] = true;
       for(int ind =1;ind<n;ind++){
           for(int target=1;target<=sum;target++){
               boolean nottake = dp[ind-1][target];

        boolean take = false;

        if (target >= arr[ind]) {
            take = dp[ind-1][target - arr[ind]];
        }


        dp[ind][target] = take || nottake;

       
           }
       }
       return dp[n-1][sum];
       
    }
}
