class Solution {
    public int longestOnes(int[] nums, int k) {
        int left = 0, max = 0, zeroes = 0, n = nums.length;
        for(int right=0; right<n; right++){
            if(nums[right] == 0) zeroes++;
            while(zeroes > k){
                if(nums[left] == 0)zeroes--;
                left++;
            }
            max = Math.max(max, right-left+1);
        }
        return max;
    }
}