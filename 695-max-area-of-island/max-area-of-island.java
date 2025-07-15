class Solution {
    private int dfs(int vis[][], int grid[][], int row, int col){
        vis[row][col] = 1;
        int dir[][] = {{-1,0}, {0,-1}, {0,1}, {1,0}};
        int area = 1;
        for(int i=0; i<4; i++){
            int nr = row + dir[i][0];
            int nc = col + dir[i][1];
            if(nr>=0 && nr<grid.length && nc>=0 && nc<grid[0].length && grid[nr][nc] == 1 && vis[nr][nc] == 0){
                area += dfs(vis, grid, nr, nc);
            
            }
        }
        return area;
    }
    public int maxAreaOfIsland(int[][] grid) {
        int n=grid.length, m = grid[0].length;
        int vis[][] = new int[n][m];
        int maxArea = 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(grid[i][j] == 1 && vis[i][j] == 0){
                    int area = dfs(vis, grid, i, j);
                    maxArea = Math.max(maxArea, area);
                }
            }
        }
        return maxArea;
    }
}