class Solution {
    public void moveZeroes(int[] nums) {
        int insertPos = 0, n = nums.length;
        for(int i=0; i<n; i++){
           if(nums[i] != 0){
                int temp = nums[insertPos];
                nums[insertPos] = nums[i];
                nums[i] = temp;
                insertPos++;
           }
        }
    }
}