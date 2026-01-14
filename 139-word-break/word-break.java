class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> dict = new HashSet<>(wordDict);
        Boolean dp[] = new Boolean[s.length() + 1];
        return f(0, s, dp, dict);
    }
    public boolean f(int i, String s, Boolean dp[], Set<String> dict){
        int n = s.length();
        if(i==n) return true;
        if(dp[i] != null) return dp[i];
        for(int j=i+1; j<=n; j++){
            if(dict.contains(s.substring(i, j)) && f(j, s, dp, dict)){
                return dp[i] = true;
            }
        }
        return dp[i] = false;
    }
}