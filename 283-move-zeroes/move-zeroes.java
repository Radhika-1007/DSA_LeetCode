class Solution {
    public void moveZeroes(int[] nums) {
        int n = nums.length;
        for(int i=0; i<n; i++){
            if(nums[i] != 0) continue;
            for(int j=i; j<n; j++){
                if(nums[i] == 0 && nums[j] != 0){
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                    break;
                }
            }
        }
    }
}