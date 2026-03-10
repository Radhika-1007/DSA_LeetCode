class Solution {
    int n;
    Boolean dp[];
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> st = new HashSet<>(wordDict);
        n = s.length();
        dp = new Boolean[n+1];
        return f(0, s, st);
    }
    public boolean f(int i, String s, Set<String> st){
        if(i==n) return true;
        if(dp[i] != null) return dp[i];
        for(int j=i+1; j<=n; j++){
            if(st.contains(s.substring(i, j)) && f(j, s, st)) return dp[i] = true;
        }
        return dp[i] = false;
    }
}