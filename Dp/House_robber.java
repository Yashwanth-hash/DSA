import java.util.*;

class Solution {

    public int f(int ind, int[] nums, int[] dp) {

        if (ind == 0)
            return nums[0];

        if (ind < 0)
            return 0;

        if (dp[ind] != -1)
            return dp[ind];

        int pick = nums[ind] + f(ind - 2, nums, dp);
        int notPick = f(ind - 1, nums, dp);

        dp[ind] = Math.max(pick, notPick);

        return dp[ind];
    }

    public int rob(int[] nums) {

        int n = nums.length;

        int[] dp = new int[n];
        Arrays.fill(dp, -1);

        return f(n - 1, nums, dp);
    }
}