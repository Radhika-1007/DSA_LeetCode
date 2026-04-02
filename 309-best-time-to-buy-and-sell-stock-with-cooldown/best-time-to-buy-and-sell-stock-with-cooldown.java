class Solution {
    int dp[][];
    int n;
    public int maxProfit(int[] prices) {
        n = prices.length;
        dp = new int[n][2];
        for(int i=0; i<n; i++) Arrays.fill(dp[i], -1);
        return f(0, 1, prices);
    }
    public int f(int i, int buy, int prices[]){
        if(i>=n) return 0;
        if(dp[i][buy] != -1) return dp[i][buy];
        if(buy == 1){
            dp[i][buy] = Math.max(f(i+1, 1, prices), -prices[i] + f(i+1, 0, prices));
        }
        else{
            dp[i][buy] = Math.max(prices[i] + f(i+2, 1, prices), f(i+1, 0, prices));
        }
        return dp[i][buy];
    }
}



























