class Solution {

    static boolean f(int arr[], int ind, int target) {

        if (target == 0) return true;

        if (ind == 0) return (arr[0] == target);

        boolean nottake = f(arr, ind - 1, target);

        boolean take = false;

        if (target >= arr[ind]) {
            take = f(arr, ind - 1, target - arr[ind]);
        }

        return take || nottake;
    }

    static boolean isSubsetSum(int arr[], int sum) {

        int n = arr.length - 1;

        return f(arr, n, sum);
    }
}