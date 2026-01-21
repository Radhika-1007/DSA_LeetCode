class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int count = 0, countMax = 0, n = nums.length;
        for(int i=0; i<n; i++){
            if(nums[i] == 1){
                count++;
                countMax = Math.max(count, countMax);
            }
            else count = 0;
        }
        return countMax;
    }
}