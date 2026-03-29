class Solution {
    int dp[][];
    public int minPathSum(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        dp = new int[n][m];
        for(int i=0; i<n; i++) Arrays.fill(dp[i], -1);
        return f(n-1, m-1, grid);
    }
    public int f(int i, int j, int grid[][]){
        if(i==0 && j==0) return grid[i][j];
        if(dp[i][j] != -1) return dp[i][j];
        int up = (i>0) ? grid[i][j] + f(i-1, j, grid): Integer.MAX_VALUE;
        int left =(j>0)? grid[i][j] + f(i, j-1, grid): Integer.MAX_VALUE;
        return dp[i][j] = Math.min(up, left);
    }
}