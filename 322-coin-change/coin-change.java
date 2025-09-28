class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int dp[][] = new int[n][amount+1];
        for(int i=0; i<n; i++){
            Arrays.fill(dp[i], -1);
        }
        int ans = f(coins, amount, n-1, dp);
        return ans >= Integer.MAX_VALUE / 2 ? -1 : ans;
    }
    private int f(int[] coins, int amount, int i, int dp[][]){
        if(amount == 0) return 0;
        if(i<0) return Integer.MAX_VALUE / 2;
        if(dp[i][amount] != -1) return dp[i][amount];
        int take = Integer.MAX_VALUE / 2;
        if(coins[i] <= amount){
            take = 1 + f(coins, amount-coins[i], i,dp);
        }
        int nottake = f(coins, amount, i-1, dp);
        return dp[i][amount] = Math.min(take, nottake);

    }
}