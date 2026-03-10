class Solution {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int i = n-2;
        while(i>=0 && nums[i] >= nums[i+1]) i--;
        if(i>=0){
            int j = n-1;
            while(nums[j] <= nums[i]) j--;
            swap(i, j, nums);
        }
        reverse(nums, i+1, n-1);
    }
    public void swap(int i, int j, int nums[]){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    public void reverse(int nums[], int l, int r){
        while(l<r) swap(l++, r--, nums);
    }
}