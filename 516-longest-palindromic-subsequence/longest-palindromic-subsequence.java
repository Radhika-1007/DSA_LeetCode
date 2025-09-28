class Solution {
    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        int dp[][] = new int[n][n];
        for(int i=0; i<n; i++){
            Arrays.fill(dp[i], -1);
        }
        return f(0, n-1, s, dp, n);
    }
    private int f(int ind1, int ind2, String s, int dp[][], int n){
        if(ind1 > n-1 || ind2 < 0) return 0;
        if(dp[ind1][ind2] != -1) return dp[ind1][ind2];
        if(s.charAt(ind1) == s.charAt(ind2)){ 
        return dp[ind1][ind2] = 1+ f(ind1+1, ind2-1, s, dp, n);
        }
        return dp[ind1][ind2] = Math.max(f(ind1+1, ind2, s, dp, n), f(ind1, ind2-1, s, dp, n));
    }
}