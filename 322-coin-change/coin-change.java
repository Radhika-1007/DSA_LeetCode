class Solution {
    int n;
    int dp[][];
    public int coinChange(int[] coins, int amount) {
        n = coins.length;
        dp = new int[n][amount+1];
        for(int i=0; i<n; i++) Arrays.fill(dp[i], -1);
        int res = f(n-1, coins, amount);
        return (res == (int)1e8)? -1: res;
    }
    private int f(int i, int coins[], int target){
        if(target == 0) return 0;
        if(i<0) return (int)1e8;
        if(dp[i][target] != -1) return dp[i][target];
        int nottake = f(i-1, coins, target);
        int take = (int)1e8;
        if(coins[i] <= target){
            take = 1 + f(i, coins, target-coins[i]);
        }
        return dp[i][target] = Math.min(take, nottake);
    }
}