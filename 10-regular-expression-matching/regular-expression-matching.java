class Solution {
    public boolean isMatch(String s, String p) {
        boolean dp[][] = new boolean[s.length()+1][p.length()+1];
        return f(0, 0, s, p, dp);
    }
    public boolean f(int i, int j, String s, String p, boolean dp[][]){
        int n = s.length(), m = p.length();
        if(j==m) return i==n;
        boolean match = (i<n && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.'));
        boolean ans;
        if(j+1<m && p.charAt(j+1) == '*'){
            ans = f(i, j+2, s, p, dp) || (match && f(i+1, j, s, p, dp));
        }
        else{
            ans = match && f(i+1, j+1, s, p, dp);
        }
        dp[i][j] = ans;
        return ans;
    }
}