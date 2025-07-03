class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
       int ini = image[sr][sc];
       int dir[][] = {{-1,0}, {0,-1}, {0, 1}, {1,0}};
       dfs(image, ini, color, sr, sc, dir);
       return image;
    }
    private void dfs(int[][] image, int ini, int color, int sr, int sc, int dir[][]){   
        image[sr][sc] = color;
        for(int i=0; i<4; i++){
            int nr = sr + dir[i][0];
            int nc = sc + dir[i][1];
            if(nr>=0 && nr<image.length && nc>=0 && nc<image[0].length && image[nr][nc] != color && image[nr][nc] == ini){
                dfs(image, ini, color, nr, nc, dir);
            }
        }
    }

}