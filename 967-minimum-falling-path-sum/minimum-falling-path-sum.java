class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int dp[][] = new int[n][n];
        for(int j=0; j<n; j++){
            dp[n-1][j] = matrix[n-1][j];
        }
       for(int i=n-2; i>=0; i--){
        for(int j=0; j<n; j++){
        int  d = matrix[i][j] + dp[i+1][j];
        int dgl = (j>0) ? matrix[i][j] + dp[i+1][j-1] : Integer.MAX_VALUE;
        int dgr = (j<n-1) ?matrix[i][j] + dp[i+1][j+1] : Integer.MAX_VALUE;
        dp[i][j] = Math.min(d, Math.min(dgl, dgr));
        }
       }
       int ans = Integer.MAX_VALUE;
        for (int j = 0; j < n; j++) {
            ans = Math.min(ans, dp[0][j]);
        }
        return ans;
    }
}