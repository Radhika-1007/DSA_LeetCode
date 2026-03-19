class Solution {
    int n, m;
    public int maxAreaOfIsland(int[][] grid) {
        n = grid.length; m = grid[0].length; 
        int vis[][] = new int[n][m];
        int dir[][] = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};
        int maxArea = Integer.MIN_VALUE;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(vis[i][j] == 0 && grid[i][j] == 1){
                    maxArea = Math.max(maxArea, dfs(i, j, grid, vis, dir));
                } 
            }
        }
        return (maxArea == Integer.MIN_VALUE)? 0: maxArea;
    }
    public int dfs(int i, int j, int[][] grid, int vis[][], int dir[][]){
        vis[i][j] = 1;
        int area = 1;
        for(int d=0; d<4; d++){
            int nr = dir[d][0] + i;
            int nc = dir[d][1] + j;
            if(nr>=0 && nr<n && nc>=0 && nc<m && grid[nr][nc] == 1 && vis[nr][nc] == 0){
                area += dfs(nr, nc, grid, vis, dir);
            }
        }
        return area;
    }
}