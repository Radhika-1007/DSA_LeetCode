class Solution {
    int n, m;
    int dp[][];
    public int numDistinct(String s, String t) {
        n = s.length(); m = t.length();
        dp = new int[n][m];
        for(int i=0; i<n; i++) Arrays.fill(dp[i], -1);
        return f(n-1, m-1, s, t);
    }
    public int f(int i, int j, String s, String t){
        if(j<0) return 1;
        if(i<0) return 0;
        if(dp[i][j] != -1) return dp[i][j];
        if(s.charAt(i) == t.charAt(j)){
            return dp[i][j] = f(i-1, j-1, s, t) + f(i-1, j, s, t);
        }
        else{
            return dp[i][j] = f(i-1, j, s, t);
        }
    }
}