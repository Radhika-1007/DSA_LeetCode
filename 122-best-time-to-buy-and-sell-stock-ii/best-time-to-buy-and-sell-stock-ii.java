class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int aheadBuy = 0; //dp[n][1]
        int aheadSell = 0; //dp[n][0]
        for(int i=n-1; i>=0; i--){
            int currBuy = Math.max(-prices[i] + aheadSell, aheadBuy);
            int currSell = Math.max(prices[i] + aheadBuy, aheadSell);
            aheadSell = currSell;
            aheadBuy = currBuy;
        }
        return aheadBuy;
    }
}