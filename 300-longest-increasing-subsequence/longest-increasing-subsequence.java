class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int dp[] = new int[n];
        Arrays.fill(dp, 1);
        for(int i=n-1; i>=0; i--){
            for(int j=i+1; j<n; j++){
                if(nums[j] > nums[i]){
                   dp[i]=Math.max(dp[i],1+dp[j]);
                }                                                          
            }
        }
        int max = 0;
        for(int i=0; i<n; i++){
            max = Math.max(dp[i], max);
        }
        return max;
    }
}