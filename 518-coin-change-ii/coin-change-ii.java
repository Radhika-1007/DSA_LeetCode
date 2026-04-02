class Solution {
    int n;
    int dp[][];
    public int change(int amount, int[] coins) {
        n = coins.length;
        dp = new int[n][amount+1];
        for(int i=0; i<n; i++) Arrays.fill(dp[i], -1);
        return f(n-1, coins, amount);
    }
    public int f(int i, int coins[], int amount){
        if(amount == 0) return 1;
        if(i < 0) return 0;
        if(dp[i][amount] != -1) return dp[i][amount];
        int nottake = f(i-1, coins, amount);
        int take = 0;
        if(coins[i] <= amount){
            take = f(i, coins, amount - coins[i]);
        }
        return dp[i][amount] = take + nottake;
    }
}