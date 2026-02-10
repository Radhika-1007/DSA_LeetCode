class Solution {
    int n;
    Integer dp[][];
    public int maxProfit(int[] prices, int fee) {
        n = prices.length;
        dp = new Integer[n+1][2];
        return f(0, 1, prices, fee);
    }
    public int f(int i, int buy, int[] prices, int fee){
        if(i==n) return 0;
        if(dp[i][buy] != null) return dp[i][buy];
        if(buy == 1){
            dp[i][buy]=Math.max(-prices[i] + f(i+1, 0, prices, fee), f(i+1, 1, prices, fee));
        }
        else{
            dp[i][buy]=Math.max(prices[i] - fee + f(i+1, 1, prices, fee), f(i+1, 0, prices, fee));
        }
        return dp[i][buy];
    }
}