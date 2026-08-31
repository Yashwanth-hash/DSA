class Solution {
    static int perfectSum(int[] arr, int target) {
        int n = arr.length;
        int[][] dp = new int[n][target + 1];

        // Base case for index 0
        if (arr[0] == 0) {
            dp[0][0] = 2; // {} and {0} both sum to 0
        } else {
            dp[0][0] = 1; // {} sums to 0
            if (arr[0] <= target) {
                dp[0][arr[0]] = 1;
            }
        }

        // Fill DP table
        for (int ind = 1; ind < n; ind++) {
            for (int sum = 0; sum <= target; sum++) {
                int notTake = dp[ind - 1][sum];
                int take = 0;
                if (arr[ind] <= sum) {
                    take = dp[ind - 1][sum - arr[ind]];
                }
                dp[ind][sum] = take + notTake;
            }
        }

        return dp[n - 1][target];
    }
}