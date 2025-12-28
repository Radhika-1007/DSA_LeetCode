class Solution {
    public int minCost(int n, int[] cuts) {
        int c = cuts.length;
        int arr[] = new int[c+2];
        int a = arr.length;
        arr[0] = 0; arr[a-1] = n;
        for(int i=1; i<a-1; i++){
            arr[i] = cuts[i-1];
        }
        Arrays.sort(arr);
        int dp[][] = new int[c+2][c+2];
        for(int i=0; i<c+2; i++) Arrays.fill(dp[i], -1);
        return f(1, a-2, arr, dp);
    }
    public int f(int i, int j, int arr[], int dp[][]){
        if(i>j) return 0;
        if(dp[i][j] != -1) return dp[i][j];
        int mini = Integer.MAX_VALUE;
        int cost;
        for(int ind = i; ind<=j; ind++){
            cost = arr[j+1] - arr[i-1] + f(i, ind-1, arr, dp) + f(ind+1, j, arr, dp);
            mini = Math.min(mini, cost);
        }
        return dp[i][j] = mini;
    }
}