class Solution {
    public int uniquePaths(int m, int n) {
        int dp[][] = new int[m][n];
        for(int i=0; i<m; i++){
            Arrays.fill(dp[i], -1);
        }
        return f(dp, m-1, n-1);
    }
    private int f(int dp[][], int i, int j){
        if(i==0 && j== 0)return 1;
        if(i<0 || j< 0) return 0;
        if(dp[i][j] != -1) return dp[i][j];
        int up = f(dp, i-1, j);
        int left = f(dp, i, j-1);
        return dp[i][j] = up+left;
    }
}