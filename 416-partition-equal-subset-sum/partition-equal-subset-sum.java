class Solution {
    public boolean canPartition(int[] nums) {
        int n = nums.length, total = 0;
        for(int i=0; i<n; i++){
            total += nums[i];
        }
        if(total % 2 != 0) return false;
        int target = total/2;
        int dp[][] = new int[n][target+1];
        for(int i=0; i<n; i++){
            Arrays.fill(dp[i], -1);
        }
        return f(n-1, target, nums, dp);
    }
    private boolean f(int ind, int target, int nums[], int dp[][]){
        if(target == 0) return true;
        if(ind == 0) return nums[ind] == target;
        if(dp[ind][target] != -1) return dp[ind][target] == 1;
        boolean nottake = f(ind-1, target, nums, dp);
        boolean take = false;
        if(target >= nums[ind]){
            take = f(ind-1, target-nums[ind], nums, dp);
        }
        boolean result = take || nottake;
        dp[ind][target] = result ? 1 : 0;

        return result;
    }
}