class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int dp[][] = new int[n][amount+1];
        for(int t=0; t<=amount; t++){
            if(t % coins[0] == 0) dp[0][t] = t / coins[0];
            else dp[0][t] = (int) 1e8;
        }
        for(int i=1; i<n; i++){
            for(int target=0; target <= amount; target++){
                int nottake = dp[i-1][target];
                int take = (int)1e8;
                if(coins[i] <= target){
                    take = 1 + dp[i][target-coins[i]];
                }
                dp[i][target] = Math.min(nottake, take);
            }
        }
        int res = dp[n-1][amount];
        return (res == (int)1e8)? -1: res;
    }
}