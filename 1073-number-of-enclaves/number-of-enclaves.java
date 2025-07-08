class Solution {
    public int numEnclaves(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int vis[][] = new int[n][m];
        int dir[][] = {{-1,0},{0,-1},{0,1},{1,0}};
        for(int j=0; j<m; j++){
            //first row
            if(vis[0][j]==0 && grid[0][j] == 1){
                dfs(grid, vis, dir, 0, j);
            }
            //last row
            if(vis[n-1][j]==0 && grid[n-1][j] == 1){
                dfs(grid, vis, dir, n-1, j);
            }
        }
        for(int i=0; i<n; i++){
            //first column
            if(vis[i][0]==0 && grid[i][0] == 1){
                dfs(grid, vis, dir, i, 0);
            }
            //last column 
            if(vis[i][m-1]==0 && grid[i][m-1]==1){
                dfs(grid, vis, dir, i, m-1);
            }
        }
        int count = 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(grid[i][j] == 1) count++;
            }
        }
        return count;
    }
    private void dfs(int[][] grid, int vis[][], int dir[][], int row, int col){
        vis[row][col] = 1;
        grid[row][col] = 0;
        for(int i=0; i<4; i++){
            int nr = row + dir[i][0];
            int nc = col + dir[i][1];
            if(nr>=0 && nr<grid.length && nc>=0 && nc<grid[0].length && vis[nr][nc] == 0 && grid[nr][nc] == 1){
                dfs(grid, vis, dir, nr, nc);
            }
        }
    }
}