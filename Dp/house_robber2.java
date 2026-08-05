class Solution {

    public int solve(int[] nums, int start, int end) {

        int prev = nums[start];
        int prev2 = 0;

        for (int i = start + 1; i <= end; i++) {

            int take = nums[i];
            if (i > start + 1)
                take += prev2;

            int notTake = prev;

            int curi = Math.max(take, notTake);

            prev2 = prev;
            prev = curi;
        }

        return prev;
    }

    public int rob(int[] nums) {

        int n = nums.length;

        if (n == 1)
            return nums[0];

        // Exclude first house
        int ans1 = solve(nums, 1, n - 1);

        // Exclude last house
        int ans2 = solve(nums, 0, n - 2);

        return Math.max(ans1, ans2);
    }
}