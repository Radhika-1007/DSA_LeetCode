class Solution {
    int n;
    int dp[][];
    public int maxCoins(int[] nums) {
        n = nums.length;
        int arr[] = new int[n+2];
        arr[0] = 1; arr[n+1] = 1;
        for(int i=1; i<=n; i++){
            arr[i] = nums[i-1];
        }
        dp = new int[n+2][n+2];
        for(int i=0; i<n+2; i++) Arrays.fill(dp[i], -1);
        return f(1, n, arr);
    }
    public int f(int i, int j, int arr[]){
        if(i>j) return 0;
        if(dp[i][j] != -1) return dp[i][j];
        int max = Integer.MIN_VALUE;
        int cost;
        for(int ind=i; ind<=j; ind++){
            cost = arr[i-1] * arr[ind] * arr[j+1] + f(i, ind-1, arr) + f(ind+1, j, arr);
            max = Math.max(cost, max);
        }
        return dp[i][j] = max;
    }
}