class Solution {
    public int maxProduct(int[] nums) {
        int maxProduct = 0;
        int product;
        int n = nums.length;
        if(n==1) return nums[0];
        for(int i=0; i<n; i++){
            product = 1;
            for(int j=i; j<n; j++){
                product *= nums[j];
                maxProduct = Math.max(maxProduct, product);
            }    
        }
        return maxProduct;
    }
}