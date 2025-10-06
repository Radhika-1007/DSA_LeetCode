class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        int dp[][] = new int[n][n];
        for(int i=0; i<n; i++){
            Arrays.fill(dp[i], -1);
        }
        int st = 0;
        int maxlen = 0;
        for(int i=0; i<n; i++){
            for(int j=i; j<n; j++){
                if(isPalin(i, j, s, dp) == 1){
                    if(j-i+1 > maxlen){
                        maxlen = j-i+1;
                        st = i;
                    }
                }
            }
        }
        return s.substring(st, st+maxlen);

    }
    private int isPalin(int i, int j, String s, int dp[][]){
        if(i>j) return 1;
        if(dp[i][j] != -1) return dp[i][j];
        if(s.charAt(i) == s.charAt(j)){
            dp[i][j] = isPalin(i+1, j-1, s, dp);
        }    
        else{
            dp[i][j] = 0;
        }
        return dp[i][j];
    }
}