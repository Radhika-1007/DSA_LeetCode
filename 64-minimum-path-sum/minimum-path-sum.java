class Solution {
    int dp[][];
    public int minPathSum(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        dp = new int[n][m];
        dp[0][0] = grid[0][0];
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(i==0 && j==0) continue;
                int up = (i>0) ? grid[i][j] + dp[i-1][j]: Integer.MAX_VALUE;
                int left =(j>0)? grid[i][j] + dp[i][j-1]: Integer.MAX_VALUE;
                dp[i][j] = Math.min(up, left);
            }
        }
        return dp[n-1][m-1];
    }
}