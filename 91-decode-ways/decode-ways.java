class Solution {
    int n;
    int dp[];
    public int numDecodings(String s) {
        n = s.length();
        dp = new int[n+1];
        Arrays.fill(dp, -1);
        return f(0, s);
    }
    private int f(int i, String s){
        if(i==n) return 1;
        if(s.charAt(i) == '0') return 0;
        if(dp[i] != -1) return dp[i];
        int ways = f(i+1, s);
        if(i+1 < n){
            int twoDigit = Integer.parseInt(s.substring(i, i+2));
            if(twoDigit >= 10 && twoDigit <=26){
                ways += f(i+2, s);
            }
        }
        return dp[i] = ways;
    }
}