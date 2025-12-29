class Solution {
    public int numIslands(char[][] grid) {
        int n = grid.length, m = grid[0].length;
        int vis[][] = new int[n][m];
        int dir[][] = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};
        int count=0;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(vis[i][j] == 0 && grid[i][j] == '1'){
                    count++;
                    dfs(i, j, grid, vis, dir);
                }
            }
        }
        return count;
    }
    public void dfs(int i, int j, char[][] grid, int vis[][], int dir[][]){
        vis[i][j] = 1;
        for(int d=0; d<4; d++){
            int nr = i + dir[d][0];
            int nc = j + dir[d][1];
            if(nr>=0 && nr<grid.length && nc>=0 && nc<grid[0].length && vis[nr][nc] == 0 && grid[nr][nc] == '1'){
                dfs(nr, nc, grid, vis, dir);
            }
        }
    }
}