class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int curMax = 0, curMin = 0, maxSum = nums[0], minSum = nums[0], total = 0;
        for(int num: nums){
            total += num;
            //max Kadan
            curMax = Math.max(num, curMax+num);
            maxSum = Math.max(maxSum, curMax);
            //min kadan
            curMin = Math.min(num, curMin+num);
            minSum = Math.min(minSum, curMin);
        }
        if(maxSum < 0) return maxSum;
        return Math.max(maxSum, total - minSum);
    }
}