class Solution {
    Boolean dp[][];
    int n;
    public boolean canPartition(int[] nums) {
        n = nums.length;
        int total = 0;
        for(int num: nums) total += num;
        if(total % 2 != 0) return false;
        int target = total/2;
        dp = new Boolean[n][target+1];
        return f(n-1, nums, target);
    }
    public boolean f(int i, int nums[], int target){
        if(target == 0) return true;
        if(i==0) return nums[i] == target;
        if(dp[i][target] != null) return dp[i][target];
        boolean nottake = f(i-1, nums, target);
        boolean take = false;
        if(nums[i] <= target){
            take = f(i-1, nums, target - nums[i]);
        }
        return dp[i][target] = take || nottake;
    }
}