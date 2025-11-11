class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        int n = matrix.length, m = matrix[0].length;
        int dir[][] = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};
        int dp[][] = new int[n+1][m+1];
        for(int i=0; i<=n; i++){
            Arrays.fill(dp[i], -1);
        }
        int ans = 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                ans = Math.max(ans, f(matrix, i, j, dir, dp));
            }
        }
        return ans;
    }
    public int f(int matrix[][], int row, int col, int dir[][], int dp[][]){
        if(dp[row][col] != -1) return dp[row][col];
        int maxlen = 1;
        for(int i=0; i<4; i++){
            int nr = row + dir[i][0];
            int nc = col + dir[i][1];
            if(nr>=0 && nr<matrix.length && nc>=0 && nc<matrix[0].length && matrix[nr][nc] > matrix[row][col]){
                int len = 1 + f(matrix, nr, nc, dir, dp);
                maxlen = Math.max(maxlen, len);
            }
        }
        dp[row][col] = maxlen;
        return maxlen;
    }
}