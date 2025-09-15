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
        return f(dp, nums, target, n-1);
    }
    private boolean f(int dp[][], int[]nums, int target, int ind){
        if(target == 0) return true;
        if(ind == 0) return nums[ind] == target;
        if(dp[ind][target] != -1) return dp[ind][target] == 1;
        boolean notTake = f(dp, nums, target, ind-1);
        boolean take = false;
        if(target >= nums[ind]){
            take = f(dp, nums, target-nums[ind], ind-1);
        }
        boolean result = notTake || take;
        dp[ind][target] = result? 1: 0;
        return result;
    }
}