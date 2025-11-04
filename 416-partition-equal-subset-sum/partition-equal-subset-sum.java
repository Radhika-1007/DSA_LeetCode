class Solution {
    public boolean canPartition(int[] nums) {
        int total = 0;
        for(int i=0; i<nums.length; i++){
            total += nums[i];
        }
        if(total % 2 != 0) return false;
        int dp[][] = new int[nums.length][(total/2)+1];
        for(int i=0; i<nums.length; i++){
            Arrays.fill(dp[i], -1);
        }
        return f(nums.length-1, nums, dp, total/2);
    }
    public boolean f(int i, int[] nums, int dp[][], int target){
        if(target == 0) return true;
        if(i==0 ) return nums[i] == target;
        if(dp[i][target] != -1) return dp[i][target] == 1;
        boolean nottake = f(i-1, nums, dp, target);
        boolean take = false;
        if(nums[i] <= target){
            take = f(i-1, nums, dp, target - nums[i]);
        }
        dp[i][target] = take || nottake ? 1: 0; 
        return take || nottake;
    }
}