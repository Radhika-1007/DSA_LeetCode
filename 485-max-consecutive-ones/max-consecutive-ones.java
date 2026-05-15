class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int n = nums.length, i = 0, max = 0;
        while(i<n){
            int count = 0;
            while(i<n && nums[i] == 1){
                count++;
                i++;
            }
            max = Math.max(max, count);
            i++;
        }
        return max;
    }
}