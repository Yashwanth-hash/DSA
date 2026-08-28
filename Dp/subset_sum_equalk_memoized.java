import java.util.*;

class Solution {

    static boolean f(int arr[], int dp[][], int ind, int target) {

        if (target == 0)
            return true;

        if (ind == 0)
            return arr[0] == target;

        if (dp[ind][target] != -1)
            return dp[ind][target] == 1;

        boolean nottake = f(arr, dp, ind - 1, target);

        boolean take = false;

        if (target >= arr[ind]) {
            take = f(arr, dp, ind - 1, target - arr[ind]);
        }

        boolean ans = take || nottake;

        dp[ind][target] = ans ? 1 : 0;

        return ans;
    }

    static boolean isSubsetSum(int arr[], int sum) {

        int n = arr.length;

        int dp[][] = new int[n][sum + 1];

        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }

        return f(arr, dp, n - 1, sum);
    }
}class Solution {
    
   static boolean f(int arr[],int dp[][],int ind,int target){
        
        if(target==0) return true;
        
        if(ind==0) return(arr[0]==target);
        
        if(dp[ind][target]!=-1) return dp[ind][target];
        boolean nottake = f(arr,dp,ind-1,target);
        boolean take = false;
        
        if(target>=arr[ind]){
            take = f(arr,dp,ind-1,target - arr[ind]);
        }
        
        dp[ind][target]= (take||nottake);
        return dp[ind][target];
        
    }
    static boolean isSubsetSum(int arr[], int sum) {

            int n = arr.length-1;
            
            int dp[][] = new int[n+1][sum+1];
            
            for(int i=0;i<n+1;i++){
                Arrays.fill(dp[i],-1);
            }
            
        return    f(arr,dp,n,sum);
    }
}