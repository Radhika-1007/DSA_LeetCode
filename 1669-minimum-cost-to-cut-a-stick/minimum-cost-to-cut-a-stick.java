class Solution {
    public int minCost(int n, int[] cuts) {
        int c = cuts.length;
        Arrays.sort(cuts);
        int arr[] = new int[c+2];
        arr[0] = 0;
        int dp[][] = new int[c+2][c+2];
        for(int i=0; i<c+1; i++) Arrays.fill(dp[i], -1);
        arr[arr.length - 1] = n;
        for(int i=1; i<arr.length-1; i++){
            arr[i] = cuts[i-1];
        }
        return f(1, c, arr, dp);
    }
    private int f(int i, int j, int[] arr, int dp[][]){
        if(i > j) return 0;
        int mini = Integer.MAX_VALUE;
        if(dp[i][j] != -1) return dp[i][j];
        for(int ind = i; ind<=j; ind++){
            int cost = arr[j+1] - arr[i-1] + f(i, ind-1, arr, dp) + f(ind+1, j, arr, dp);
            mini = Math.min(mini, cost);
        } 
        return dp[i][j] = mini;
    }
}