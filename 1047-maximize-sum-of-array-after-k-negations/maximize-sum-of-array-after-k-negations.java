class Solution {
    public int largestSumAfterKNegations(int[] nums, int k) {
        Arrays.sort(nums);
        for(int i = 0; i < nums.length && k > 0; i++){
            if(nums[i] < 0){
                nums[i] = -nums[i];
                k--;
            }
        }
        int sum = 0, min = Integer.MAX_VALUE, n = nums.length;
        for(int i=0; i<n; i++){
            sum += nums[i];
            min = Math.min(min, nums[i]);
        }
        if(k%2!=0){
            sum -= 2 * min;
        }
        return sum;
       
    }
}