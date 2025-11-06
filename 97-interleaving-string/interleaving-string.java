class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        int n = s1.length(), m = s2.length();
        if(n+m < s3.length()) return false;
        int dp[][] = new int[n+1][m+1];
        for(int i=0; i<=n; i++) Arrays.fill(dp[i], -1);
        return f(s1, s2, s3, dp, 0, 0, 0);
    }
    public boolean f(String s1, String s2, String s3, int dp[][], int i, int j, int k){
        if(k==s3.length()) return (i==s1.length()) && (j==s2.length());
        if(dp[i][j] != -1) return dp[i][j] == 1;
        boolean res = false;
        if(i<s1.length() && k<s3.length() && s1.charAt(i) == s3.charAt(k)){
            res = f(s1, s2, s3, dp, i+1, j, k+1);
        }
         if(j<s2.length() && k<s3.length() && s2.charAt(j) == s3.charAt(k) && !res){
            res = f(s1, s2, s3, dp, i, j+1, k+1);
        }
        dp[i][j] = res? 1:0;
        return res;
    }


}