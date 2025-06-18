class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int ini = image[sr][sc];
        if(ini == color) return image;
        int delr[] = {-1, 0, 1, 0};
        int delc[] = {0, 1, 0, -1};
        dfs(image, sr, sc, color, ini, delr, delc);
        return image;
    }
    private void dfs(int image[][], int sr, int sc, int color, int ini, int delr[], int delc[]){
        image[sr][sc] = color;
        int n = image.length;
        int m = image[0].length;
        for(int i=0; i<4; i++){
            int nr = sr + delr[i];
            int nc = sc + delc[i];
            if(nr >= 0 && nr < n && nc >= 0 && nc < m && image[nr][nc] == ini && image[nr][nc] != color){
                dfs(image, nr, nc, color, ini, delr, delc);
            }
        }
    }
}