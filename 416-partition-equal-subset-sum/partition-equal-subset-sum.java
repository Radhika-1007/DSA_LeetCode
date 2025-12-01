class Solution {
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int total = 0;
        for(int i=0; i<n; i++){
            total += nums[i];
        }
        int target = total/2;
        if(total % 2 != 0) return false;
        int dp[][] = new int[n][target+1];
        for(int i=0; i<n; i++) Arrays.fill(dp[i], -1);
        return f(n-1, target, nums, dp);
    }
    private boolean f(int i, int target, int nums[], int dp[][]){
        if(target == 0) return true;
        if(i==0) return nums[0] == target;
        if(dp[i][target] != -1) return dp[i][target] == 1;
        boolean nottake = f(i-1, target, nums, dp);
        boolean take = false;
        if(nums[i] <= target){
            take = f(i-1, target-nums[i], nums, dp);
        }
        boolean result = take || nottake;
        dp[i][target] = result? 1: 0;
        return result;
    }
}