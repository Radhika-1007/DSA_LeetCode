class Solution {
    public int countSubstrings(String s) {
        int n = s.length();
        if(n==1) return 1;
        int dp[][] = new int[n][n];
        for(int i=0; i<n; i++){
            Arrays.fill(dp[i], -1);
        }
        int count = 0;
        for(int i=0; i<n; i++){
            for(int j=i; j<n; j++){
                if(i==j) count+=1;
                else{
                    if(isPalin(s, i, j, dp) == 1){
                        count+=1;
                    }
                }
            }
        }
        return count;
    }
    private int isPalin(String s, int i, int j, int dp[][]){
        if(i>=j) return 1;
        if(s.charAt(i) == s.charAt(j)){
            return dp[i][j] = isPalin(s, i+1, j-1, dp);
        }
        else return dp[i][j] = 0;
    }
}