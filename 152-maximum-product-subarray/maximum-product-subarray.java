class Solution {
    public int maxProduct(int[] nums) {
        int minProd = 1, maxProd = 1;
        int res = nums[0];
        for(int num: nums){
            int temp = num * maxProd;
            maxProd = Math.max(num, Math.max(num*maxProd, num*minProd));
            minProd = Math.min(num, Math.min(num*minProd, temp));
            res = Math.max(maxProd, res);
        }
        return res;
    }
}