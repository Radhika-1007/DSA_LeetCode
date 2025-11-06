class Solution {
    public int numIslands(char[][] grid) {
        int n = grid.length, m = grid[0].length;
        int dir[][] = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};
        int vis[][] = new int[n][m];
        int count = 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(vis[i][j] == 0 && grid[i][j] == '1'){
                    count++;
                    dfs(vis, i, j, grid, dir);
                }
            }
        }
        return count;
    }
    public void dfs(int vis[][], int row, int col, char grid[][], int dir[][]){
        vis[row][col] = 1;
        for(int i=0; i<4; i++){
            int nr = row + dir[i][0];
            int nc = col + dir[i][1];
            if(nr >= 0 && nr < grid.length && nc >= 0 && nc < grid[0].length && grid[nr][nc] == '1' && vis[nr][nc] == 0){
                dfs(vis, nr, nc, grid, dir);
            }
        }
    }
}