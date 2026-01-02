class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int n = heights.length, m = heights[0].length;
        boolean pacific[][] = new boolean[n][m];
        boolean atlantic[][] = new boolean[n][m];
        List<List<Integer>> result = new ArrayList<>();
        for(int i=0; i<n; i++){
            dfs(i, 0, heights, pacific);
            dfs(i, m-1, heights, atlantic);
        }
        for(int j=0; j<m; j++){
            dfs(0, j, heights, pacific);
            dfs(n-1, j, heights, atlantic);
        }
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(pacific[i][j] == true && atlantic[i][j] == true){
                    result.add(new ArrayList<>(Arrays.asList(i, j)));
                }
            }
        }
        return result;
    }
    public void dfs(int i, int j, int heights[][], boolean ocean[][]){
        ocean[i][j] = true;
        int dir[][] = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};
        for(int d=0; d<4; d++){
            int nr = i + dir[d][0];
            int nc = j + dir[d][1];
            if(nr>=0 && nr<heights.length && nc>=0 && nc<heights[0].length && heights[nr][nc] >= heights[i][j] && !ocean[nr][nc]){
                dfs(nr, nc, heights, ocean);
            }
        }
    }
}