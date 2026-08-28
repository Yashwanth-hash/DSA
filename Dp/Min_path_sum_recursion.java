class Solution {

    public int minFallingPathSum(int[][] matrix) {

        int n = matrix.length;
        int min = (int) 1e9;

        for (int j = 0; j < n; j++) {
            int mini = minSum(matrix, n - 1, j);
            min = Math.min(mini, min);
        }

        return min;
    }

    private int minSum(int[][] arr, int i, int j) {

        int n = arr.length;

        if (i < 0 || j < 0 || i >= n || j >= n) {
            return (int) 1e9;
        }

        if (i == 0)
            return arr[0][j];

        int up = arr[i][j] + minSum(arr, i - 1, j);

        int right = arr[i][j] + minSum(arr, i - 1, j + 1);

        int left = arr[i][j] + minSum(arr, i - 1, j - 1);

        return Math.min(up, Math.min(left, right));
    }
}