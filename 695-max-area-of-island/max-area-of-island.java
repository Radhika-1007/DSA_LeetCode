class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        int vis[][] = new int[n][m];
        int maxArea = 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(vis[i][j] == 0 && grid[i][j] == 1){
                    maxArea = Math.max(maxArea, dfs(i, j, grid, vis));
                }
            }
        }
        return maxArea;
    }
    public int dfs(int i, int j, int grid[][], int vis[][]){
        vis[i][j] = 1;
        int area = 1;
        int dir[][] = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        for(int d=0; d<4; d++){
            int nr = i + dir[d][0];
            int nc = j + dir[d][1];
            if(nr>=0 && nr<grid.length && nc>=0 && nc<grid[0].length && vis[nr][nc] == 0 && grid[nr][nc] == 1){
                area += dfs(nr, nc, grid, vis);
            }
        }
        return area;
    }
}