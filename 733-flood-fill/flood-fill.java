class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int n = image.length, m = image[0].length;
        int ini = image[sr][sc];
        int vis[][] = new int[n][m];
        int dir[][] = {{-1,0},{0,-1},{0,1},{1,0}};
        dfs(image, ini, color, dir, vis, sr, sc);
        return image;
    }
    private void dfs(int[][] image, int ini, int color, int dir[][], int vis[][], int sr, int sc){
        vis[sr][sc] = 1;
        image[sr][sc] = color;
        for(int i=0; i<4; i++){
            int nr = sr + dir[i][0], nc = sc + dir[i][1];
            if(nr>=0 && nr<image.length && nc>=0 && nc<image[0].length && image[nr][nc] == ini && vis[nr][nc] == 0){
                image[nr][nc] = color;
                dfs(image, ini, color, dir, vis, nr, nc);
            }
        }
    }
}