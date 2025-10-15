class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int dp[][] = new int[n][2];
        for(int i=0; i<n; i++){
            Arrays.fill(dp[i], -1);
        }
        return f(0, 1, dp, prices);
    }
    private int f(int ind, int buy, int dp[][], int prices[]){
        if(ind >= prices.length) return 0;
        if(dp[ind][buy] != -1) return dp[ind][buy];
        if(buy==1){
            return dp[ind][buy] = Math.max(-prices[ind] + f(ind, 0, dp, prices), 0 + f(ind+1, 1, dp, prices) );
        }
        else{
            return dp[ind][buy] = Math.max(prices[ind] + f(ind+2, 1, dp, prices), 0 + f(ind+1, 0, dp, prices));
        }
    }
}