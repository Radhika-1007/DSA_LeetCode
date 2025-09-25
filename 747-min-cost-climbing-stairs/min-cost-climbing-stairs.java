class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int dp[] = new int[n+1];
        Arrays.fill(dp, -1);
        return f(cost, dp, n);
    }
    private int f(int[] cost, int[] dp, int ind){
        if (ind == 0 || ind == 1) return 0; 
        if(dp[ind] != -1) return dp[ind];
        int onestep = cost[ind-1] + f(cost, dp, ind-1);
        int twostep =  cost[ind-2] + f(cost, dp, ind-2);
        return dp[ind] = Math.min(onestep, twostep);
    }
}