class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n==1) return nums[0];
        return Math.max(f(0, n-2, nums), f(1, n-1, nums));
    }
    public int f(int start, int end, int nums[]){
       int prev2 = 0, prev1 = 0;
        for(int i=start; i<=end; i++){
            int take = nums[i] + prev2;
            int nottake = prev1;
            int curr = Math.max(take, nottake);
            prev2 = prev1;
            prev1 = curr;
        }
        return prev1;
    }
}