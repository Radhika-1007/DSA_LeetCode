class Solution {
    public int climbStairs(int n) {
      int dp[] = new int[n+1];
      Arrays.fill(dp, -1); 
      return cache(dp, n); 
    }
    private int cache(int dp[], int n){
        if(n<=0){
            if(n==0) return 1;
            else return 0;
        }
        if(dp[n] != -1) return dp[n];
        
        return dp[n] = cache(dp, n-1) + cache(dp, n-2);
    }
}