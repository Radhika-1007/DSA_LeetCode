class Solution {
    public int numEnclaves(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int dir[][] = {{-1,0},{0,-1},{0,1},{1,0}};
        for(int j=0; j<m; j++){
            //first row
            if(grid[0][j] == 1) dfs(grid, dir, 0, j);
            //last row
            if(grid[n-1][j] == 1) dfs(grid, dir, n-1, j);
        }
        for(int i=0; i<n; i++){
            //first column
            if(grid[i][0] == 1) dfs(grid, dir, i, 0);
            //last column 
            if(grid[i][m-1]==1) dfs(grid, dir, i, m-1);
        }
        int count = 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(grid[i][j] == 1) count++;
            }
        }
        return count;
    }
    private void dfs(int[][] grid, int dir[][], int row, int col){
        grid[row][col] = 0;
        for(int i=0; i<4; i++){
            int nr = row + dir[i][0];
            int nc = col + dir[i][1];
            if(nr>=0 && nr<grid.length && nc>=0 && nc<grid[0].length && grid[nr][nc] == 1){
                dfs(grid, dir, nr, nc);
            }
        }
    }
}