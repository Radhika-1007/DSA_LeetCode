class Solution {
    public boolean checkpossible(String s1, String s2){
        int n = s1.length(), m = s2.length();
        if(s1.length() != s2.length() + 1) return false;
        int first = 0, second = 0;
        while(first < n){
            if(second < m && s1.charAt(first) == s2.charAt(second)){
                first++;
                second++;
            }
            else{
                first++;
            }
        }
        if(first == n && second == m) return true;
        else return false;
    }
    public int longestStrChain(String[] words) {
        int n = words.length;
        int dp[] = new int[n];
        Arrays.fill(dp, 1);
        Arrays.sort(words, (a,b) -> Integer.compare(a.length(), b.length()));
        int maxi = 1;
        for(int i=0; i<n; i++){
            for(int prev=0; prev<i; prev++){
                if(checkpossible(words[i], words[prev]) && 1+dp[prev] > dp[i]){
                    dp[i] = 1+dp[prev];
                }
            }
            if(dp[i] > maxi) maxi = dp[i];
        }
        return maxi;
    }
}