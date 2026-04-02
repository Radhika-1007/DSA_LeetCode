class Solution {
    int n, m;
    int dir[][] = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    int dp[][];
    public int longestIncreasingPath(int[][] matrix) {
        n = matrix.length; m = matrix[0].length;
        int ans = Integer.MIN_VALUE;
        dp = new int[n][m];
        for(int i=0; i<n; i++) Arrays.fill(dp[i], -1);
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                ans = Math.max(ans, f(i, j, matrix));
            }
        }
        return ans;
    }
    public int f(int i, int j, int matrix[][]){
        if(dp[i][j] != -1) return dp[i][j];
        int ans = 1;
        for(int d=0; d<4; d++){
            int nr = i + dir[d][0];
            int nc = j + dir[d][1];
            if(nr>=0 && nr<n && nc>=0 && nc<m && matrix[i][j] < matrix[nr][nc]){
                ans = Math.max(ans, 1 + f(nr, nc, matrix));
            }
        }
        return dp[i][j] = ans;
    }
}