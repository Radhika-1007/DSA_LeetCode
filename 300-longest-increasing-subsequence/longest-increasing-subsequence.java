class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length, max = Integer.MIN_VALUE;
        if(n==1) return 1;
        int dp[] = new int[n];
        Arrays.fill(dp, 1);
        for(int i=1; i<n; i++){
            for(int prev = 0; prev<=i; prev++){
                if(nums[i] > nums[prev]){
                    if(dp[i] < 1+dp[prev]) dp[i] = 1 + dp[prev];
                }
                max = Math.max(max, dp[i]);
            }
        }
        return max;
    }
}