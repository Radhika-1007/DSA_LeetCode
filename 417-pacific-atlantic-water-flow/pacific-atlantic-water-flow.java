class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int n = heights.length;
        int m = heights[0].length;
        boolean pacific[][] = new boolean[n][m];
        boolean atlantic[][] = new boolean[n][m];
        List<List<Integer>> result = new ArrayList<>();
        for(int i=0; i<n; i++){
            dfs(heights, i, 0, pacific);
            dfs(heights, i, m-1, atlantic);
        }
        for(int j=0; j<m; j++){
            dfs(heights, 0, j, pacific);
            dfs(heights, n-1, j, atlantic);
        }
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(pacific[i][j] && atlantic[i][j]){
                    result.add(Arrays.asList(i,j));
                }
            }
        }
        return result;
    }
    private void dfs(int[][] heights, int row, int col, boolean ocean[][]){
        ocean[row][col] = true;
        int dir[][] = {{-1,0}, {0,-1}, {0,1}, {1,0}};
        for(int i=0; i<4; i++){
            int nr = row + dir[i][0];
            int nc = col + dir[i][1];
            if(nr>=0 && nr<heights.length && nc>=0 && nc<heights[0].length && ocean[nr][nc] == false && heights[nr][nc] >= heights[row][col]){
                dfs(heights, nr, nc, ocean);
            }
        }
    }
}