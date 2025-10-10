class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> dict = new HashSet<>(wordDict);
        Boolean dp[] = new Boolean[s.length()];
        return f(0, s, dict, dp);

    }
    public boolean f(int i, String s, Set<String> dict, Boolean dp[]){
        int n = s.length();
        if(i == n) return true;
        if(dp[i] != null) return dp[i]; 
        for(int j=i+1; j<=n; j++){
            String word = s.substring(i, j);
            if(dict.contains(word) && f(j, s, dict, dp)){
                return dp[i] = true;
            }
        }
        return dp[i] = false;
    }
}