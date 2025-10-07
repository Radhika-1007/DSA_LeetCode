class Solution {
    public int maxProduct(int[] nums) {
        int preffix = 1, suffix = 1;
        int n = nums.length;
        int maxi = Integer.MIN_VALUE;
        for(int i=0; i<n; i++){
            if(preffix == 0) preffix = 1;
            if(suffix == 0) suffix = 1;
            preffix *= nums[i];
            suffix *= nums[n-i-1];
            maxi = Math.max(maxi, Math.max(preffix, suffix));
        }
        return maxi;
    }
}