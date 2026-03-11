class Solution {
    public double findMaxAverage(int[] nums, int k) {
       int sum = 0, left = 0, n = nums.length;
       double maxAvg = -1e9;
       for(int right = 0; right<n; right++){
            sum += nums[right];
            if(right >= k){
                sum -= nums[left];
                left++;
            }
            if(right >= k - 1){
                maxAvg = Math.max(maxAvg, (double)sum / k);
            }
       } 
       return maxAvg;
    }
}