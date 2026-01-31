class Solution {
    public int minCut(String s) {
        int n = s.length();
        int dp[] = new int[n+1];
        Arrays.fill(dp, -1);
        return f(0, s, dp, n) - 1;
    }
    public int f(int i, String s, int dp[], int n){
        if(i==n) return 0;
        if(dp[i] != -1) return dp[i];
        StringBuilder temp = new StringBuilder("");
        int min = Integer.MAX_VALUE;
        for(int j=i; j<n; j++){
            temp.append(s.charAt(j));
            if(isPalindrome(i, j, s)){
                int cut = 1 + f(j+1, s, dp, n);
                min = Math.min(cut, min);
            }
        }
        dp[i] = min;
        return dp[i];
    }
    public boolean isPalindrome(int i, int j, String s){
        while(i<j){
            if(s.charAt(i) != s.charAt(j)) return false;
            i++; j--;
        }
        return true;
    }
}