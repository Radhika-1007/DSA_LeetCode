class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        return atMostK(nums, k) - atMostK(nums, k-1);
    }
    private int atMostK(int[] nums, int k){
        if(k<0) return 0;
        int n = nums.length;
        int left = 0, right = 0, result = 0, oddCount = 0;
        while(right < n){
            if(nums[right] % 2 != 0) oddCount++;
            while(oddCount > k){
                if(nums[left] % 2 != 0) oddCount--;
                left++;
            }
            result += right - left + 1;
            right++;
        }
        return result;
    }
}