class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int n = image.length, m = image[0].length;
        int ini = image[sr][sc];
           if(ini == color) return image;
        int dir[][] = {{-1,0},{0,-1},{0,1},{1,0}};
        dfs(image, ini, color, dir, sr, sc);
        return image;
    }
    private void dfs(int[][] image, int ini, int color, int dir[][], int sr, int sc){
        image[sr][sc] = color;
        for(int i=0; i<4; i++){
            int nr = sr + dir[i][0], nc = sc + dir[i][1];
            if(nr>=0 && nr<image.length && nc>=0 && nc<image[0].length && image[nr][nc] == ini && image[nr][nc] != color){
                image[nr][nc] = color;
                dfs(image, ini, color, dir, nr, nc);
            }
        }
    }
}