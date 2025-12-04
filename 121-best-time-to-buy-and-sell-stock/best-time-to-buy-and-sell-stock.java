class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0, buyPrice = Integer.MAX_VALUE;
        for(int i=0; i<prices.length; i++){
            if(prices[i] < buyPrice){
                buyPrice = prices[i];
            }
            else{
                maxProfit = Math.max(prices[i] - buyPrice, maxProfit);
            }
        }
        return maxProfit;
    }
}