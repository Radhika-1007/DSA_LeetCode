class Solution {
    int n;
    int dp[][];
    public int findTargetSumWays(int[] nums, int target) {
        n = nums.length;
        int total = 0;
        for(int num: nums) total += num;
        dp = new int[n][2*total+1];
        for(int i=0; i<n; i++) Arrays.fill(dp[i], -1);
        return f(0, 0, target, nums, total);
    }
    public int f(int i, int sum, int target, int nums[], int total){
        if(i==n)return (sum == target)? 1: 0;
        if(dp[i][sum+total] != -1) return dp[i][sum+total];
        int add = f(i+1, sum + nums[i], target, nums, total);
        int sub = f(i+1, sum - nums[i], target, nums, total);
        return dp[i][sum + total] = add + sub;
    }
}