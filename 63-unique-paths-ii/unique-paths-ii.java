class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        int dp[][] = new int[m][n];
        for(int i=0; i<m; i++){
            Arrays.fill(dp[i], -1);
        }
        return f(dp, m-1, n-1, obstacleGrid);
    }
    private int f(int dp[][], int i, int j, int obstacleGrid[][]){
        if(i<0 || j<0) return 0;
        if (obstacleGrid[i][j] == 1) return 0;
        if(i==0 && j==0) return 1;
        if(dp[i][j] != -1) return dp[i][j];
        int up = f(dp, i-1, j, obstacleGrid);
        int left = f(dp, i, j-1, obstacleGrid);
        return dp[i][j] = up+left;
    }
}