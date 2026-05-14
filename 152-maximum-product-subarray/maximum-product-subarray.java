class Solution {
    public int maxProduct(int[] nums) {
        int maxProd = nums[0], minProd = nums[0], res = nums[0], n = nums.length;
        for(int i=1; i<n; i++){
            int temp = nums[i] * maxProd;
            maxProd = Math.max(nums[i], Math.max(nums[i] * maxProd, nums[i] * minProd));
            minProd = Math.min(nums[i], Math.min(nums[i] * minProd, temp));
            res = Math.max(res, maxProd);
        }
        return res;
    }
}