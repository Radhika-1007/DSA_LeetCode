class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int dp[] = new int[n+1];
        Arrays.fill(dp, -1);
        return cache(n-1, nums, dp);
    }
    public int cache(int ind, int[] nums, int dp[]){
        if(ind == 0) return nums[ind];
        if(ind<0) return 0;
        if(dp[ind] != -1) return dp[ind];
        int pick = nums[ind] + cache(ind-2, nums, dp);
        int notpick = 0 + cache(ind-1, nums, dp);
        return dp[ind] = Math.max(pick, notpick);
    }
}