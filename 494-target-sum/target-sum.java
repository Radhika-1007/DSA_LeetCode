class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int total = 0, n = nums.length;
        for(int num: nums) total += num;
        int dp[][] = new int[n][2*total+1];
        for(int i=0; i<n; i++) Arrays.fill(dp[i], -1);
        return f(0, 0, target, nums, dp, total);
    }
    public int f(int i, int sum, int target, int nums[], int dp[][], int total){
        if(i == nums.length) return (sum == target)? 1: 0;
        if(dp[i][sum + total] != -1) return dp[i][sum+total];
        int add = f(i+1, sum + nums[i], target, nums, dp, total);
        int sub = f(i+1, sum - nums[i], target, nums, dp, total);
        return dp[i][sum + total] = add + sub;
        }
}