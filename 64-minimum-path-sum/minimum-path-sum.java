class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int dp[][] = new int[m][n];
        for(int i=0; i<m; i++){
            Arrays.fill(dp[i], -1);
        }
        return f(dp, grid, m-1, n-1);
    }
    private int f(int dp[][], int grid[][], int i, int j){
        if(i==0 && j==0) return grid[0][0];
        if(dp[i][j] != -1) return dp[i][j];
        int up = (i > 0) ? grid[i][j] + f(dp, grid, i-1, j) : Integer.MAX_VALUE;
        int left = (j > 0) ? grid[i][j] + f(dp, grid, i, j-1) : Integer.MAX_VALUE;

        return dp[i][j] = Math.min(up, left);
    }
}