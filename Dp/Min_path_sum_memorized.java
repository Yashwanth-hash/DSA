import java.util.*;

class Solution {

    public int minFallingPathSum(int[][] matrix) {

        int n = matrix.length;
        int min = (int) 1e9;

        int[][] dp = new int[n][n];

        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }

        for (int j = 0; j < n; j++) {
            int mini = minSum(matrix, dp, n - 1, j);
            min = Math.min(mini, min);
        }

        return min;
    }

    private int minSum(int[][] arr, int[][] dp, int i, int j) {

        int n = arr.length;

        if (i < 0 || j < 0 || i >= n || j >= n) {
            return (int) 1e9;
        }

        // Base case
        if (i == 0) {
            return arr[0][j];
        }

        // Already calculated
        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        int up = arr[i][j] + minSum(arr, dp, i - 1, j);

        int right = arr[i][j] + minSum(arr, dp, i - 1, j + 1);

        int left = arr[i][j] + minSum(arr, dp, i - 1, j - 1);

        dp[i][j] = Math.min(up, Math.min(left, right));

        return dp[i][j];
    }
}