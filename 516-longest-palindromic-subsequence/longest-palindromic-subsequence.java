class Solution {
    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        int dp[][] = new int[n][n];
        for(int i=0; i<n; i++){
            Arrays.fill(dp[i], -1);
        }
        return f(0, n-1, s, dp);
    }
    private int f(int i, int j, String s, int dp[][]){
        if(i>j) return 0;
        if(i==j) return 1;
        if(dp[i][j] != -1) return dp[i][j];
        if(s.charAt(i) == s.charAt(j)){
            return dp[i][j] = 2 + f(i+1, j-1, s, dp);
        }
        return dp[i][j] = Math.max(f(i+1, j, s, dp), f(i, j-1, s, dp));
    }
}