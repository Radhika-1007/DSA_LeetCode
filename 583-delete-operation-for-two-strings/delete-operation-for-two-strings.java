class Solution {
    public int minDistance(String word1, String word2) {
        int dp[][] = new int[word1.length()][word2.length()];
        for(int i=0; i<word1.length(); i++) Arrays.fill(dp[i], -1);
        return f(0, 0, word1, word2, dp);
    }
    public int f(int i, int j, String s, String t, int dp[][]){
        if(i==s.length()) return t.length() - j;
        if(j==t.length()) return s.length() - i;
        if(dp[i][j] != -1) return dp[i][j];
        if(s.charAt(i) == t.charAt(j)) return dp[i][j] = f(i+1, j+1, s, t, dp);
        return dp[i][j] = 1 + Math.min(f(i+1, j, s, t, dp), f(i, j+1, s, t, dp));
    }
}