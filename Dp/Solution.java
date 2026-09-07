public class Solution {
    public int findTargetSumWays(int[] nums, int target) {

        int n = nums.length;

        int total = 0;
        for(int x : nums) {
            total += x;
        }

        // Impossible cases
        if(total + target < 0 || (total + target) % 2 != 0) {
            return 0;
        }

        int sum = (total + target) / 2;

        int[][] dp = new int[n][sum + 1];

        // Base case for index 0
        if(nums[0] == 0) {
            dp[0][0] = 2;
        } 
        else {
            dp[0][0] = 1;

            if(nums[0] <= sum) {
                dp[0][nums[0]] = 1;
            }
        }

        // Fill DP table
        for(int ind = 1; ind < n; ind++) {

            for(int s = 0; s <= sum; s++) {

                int notTake = dp[ind - 1][s];

                int take = 0;

                if(nums[ind] <= s) {
                    take = dp[ind - 1][s - nums[ind]];
                }

                dp[ind][s] = take + notTake;
            }
        }

        return dp[n - 1][sum];
    }
} {
    
}
