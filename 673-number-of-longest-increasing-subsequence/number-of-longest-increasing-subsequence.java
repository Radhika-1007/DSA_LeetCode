class Solution {
    public int findNumberOfLIS(int[] nums) {
        int n = nums.length, max = Integer.MIN_VALUE;
        if(n==1) return 1;
        int dp[] = new int[n];
        int cnt[] = new int[n];
        Arrays.fill(dp, 1);
        Arrays.fill(cnt, 1);
        for(int i=1; i<n; i++){
            for(int prev=0; prev<i; prev++){
                if(nums[prev] < nums[i] && 1+dp[prev] > dp[i]){
                    dp[i] = 1+dp[prev];
                    cnt[i] = cnt[prev];
                }
                else if(nums[prev] < nums[i] && 1+dp[prev] == dp[i]){
                    cnt[i] += cnt[prev];
                }
            }
            max = Math.max(dp[i], max);
        }
        int nos=0;
        for(int i=0; i<n; i++){
            if(dp[i] == max) nos += cnt[i];
        }
        return nos;
    }
}