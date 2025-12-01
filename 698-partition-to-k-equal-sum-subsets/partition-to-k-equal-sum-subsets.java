class Solution {
    int sumTarget;
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0, n = nums.length;
        for(int i: nums) sum += i;
        if(sum % k != 0) return false;
        sumTarget = sum/k;
        boolean used[] = new boolean[n];
        return f(n-1, sumTarget, k, nums, used);
    }
    private boolean f(int i, int target, int k, int nums[], boolean used[]){
        if(k==0) return true;
        if(target == 0) return f(nums.length-1, sumTarget, k-1, nums, used);
        for(int j=i; j>=0; j--){
            if(used[j] || target - nums[j] < 0) continue;
            used[j] = true;
            if(f(j-1, target-nums[j], k, nums, used)) return true;
            used[j] = false;
        }
        return false;
    }
}