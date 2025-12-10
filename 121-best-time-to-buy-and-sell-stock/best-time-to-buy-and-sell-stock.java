class Solution {
    public int maxProfit(int[] prices) {
        int cost = Integer.MAX_VALUE, maxProfit = 0;
        for(int i=0; i<prices.length; i++){
            if(prices[i] < cost) cost = prices[i];
            else maxProfit = Math.max(maxProfit, prices[i] - cost);
        }
        return maxProfit;
    }
}