class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int dp[] = new int[n];
        Arrays.fill(dp, 1);
        int maxi = Integer.MIN_VALUE;
        for(int i=0; i<n; i++){
            for(int prev = 0; prev<i; prev++){
                if(nums[prev] < nums[i]){
                    dp[i] = Math.max(1+dp[prev], dp[i]);
                }
            }
            maxi = Math.max(maxi, dp[i]);
        }
        return maxi;
    }
}