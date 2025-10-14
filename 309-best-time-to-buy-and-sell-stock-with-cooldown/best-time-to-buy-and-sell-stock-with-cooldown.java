class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int dp[][] = new int[n][2];
        for(int i=0; i<n; i++){
            Arrays.fill(dp[i], -1);
        }
        return f(0, 1, prices, dp);
    }
    private int f(int i, int buy, int[] prices, int dp[][]){
        if(i>= prices.length) return 0;
        if(dp[i][buy] != -1) return dp[i][buy];
        if(buy == 1){
            return dp[i][buy] = Math.max( -prices[i] + f(i+1, 0, prices, dp), 0+ f(i+1, 1, prices, dp));
        }
        else{
            return dp[i][buy] = Math.max(prices[i] + f(i+2, 1, prices, dp), 0+f(i+1, 0, prices, dp));
        }
    }
}