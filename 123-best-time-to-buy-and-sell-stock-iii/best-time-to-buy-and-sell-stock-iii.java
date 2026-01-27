class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int dp[][] = new int[n+1][5];
        for(int i=n-1; i>=0; i--){
            for(int trans = 3; trans>=0; trans--){
                if(trans % 2 == 0){
                    dp[i][trans] = Math.max(-prices[i] + dp[i+1][trans+1], dp[i+1][trans]);
                }
                else{
                    dp[i][trans] = Math.max(prices[i] + dp[i+1][trans+1], dp[i+1][trans]);
                }
            }
        }
        return dp[0][0];
    }
}