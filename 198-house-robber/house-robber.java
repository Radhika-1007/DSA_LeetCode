class Solution {
    public int rob(int[] nums) {
        int dp[] = new int[nums.length + 1];
        Arrays.fill(dp, -1);
        return f(nums, dp, nums.length-1);
    }
    private int f(int nums[], int dp[], int ind){
        if(ind == 0) return nums[ind];
        if(ind < 0) return 0;
        if(dp[ind] != -1) return dp[ind];
        int pick = nums[ind] + f(nums, dp, ind-2);
        int notpick = f(nums, dp, ind-1);
        return dp[ind] = Math.max(pick, notpick);
    }
}