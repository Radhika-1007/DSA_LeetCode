class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int dp[][] = new int[n][amount+1];
        for(int i=0; i<n; i++) Arrays.fill(dp[i], -1);
        int res = f(n-1, amount, coins, dp);
        return (res == (int)1e8)? -1: res;
    }
    public int f(int i, int amount, int coins[], int dp[][]){
        if(amount == 0) return 0;
        if(i<0) return (int)1e8; 
        if(dp[i][amount] != -1) return dp[i][amount];
        int nottake = f(i-1, amount, coins, dp);
        int take = (int)1e8; 
        if(coins[i] <=amount){
            take = 1 + f(i, amount - coins[i], coins, dp);
        }
        return dp[i][amount] = Math.min(take , nottake);
    }
}