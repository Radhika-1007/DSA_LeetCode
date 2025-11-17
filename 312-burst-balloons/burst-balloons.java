class Solution {
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int arr[] = new int[n+2];
        arr[0] = 1;
        arr[arr.length-1] = 1;
        for(int i=1; i<arr.length-1; i++){
            arr[i] = nums[i-1];
        }
        int dp[][] = new int[n+2][n+2];
        for(int i=0; i<n+2; i++){
            Arrays.fill(dp[i], -1);
        }
        return f(1, n, arr, dp);
    }
    public int f(int i, int j, int arr[], int dp[][]){
        if(i>j) return 0;
        int cost;
        int max = Integer.MIN_VALUE;
        if(dp[i][j] != -1) return dp[i][j];
        for(int ind = i; ind<=j; ind++){
            cost = arr[i-1] * arr[ind] * arr[j+1] + f(i, ind-1, arr, dp) + f(ind+1, j, arr, dp);
            max = Math.max(max, cost);
        }
        return dp[i][j] = max;
    }
}