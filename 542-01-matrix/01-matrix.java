class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        int vis[][] = new int[n][m];
        int dist[][] = new int[n][m];
        Queue<int[]> q = new LinkedList<>();
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(mat[i][j] == 0) {
                    q.offer(new int[] {i, j, 0});
                    vis[i][j] = 1;
                }  
            }
        }
        int dir[][] = {{-1, 0}, {0, -1}, {0,1}, {1, 0}};
        while(!q.isEmpty()){
            int[] p = q.poll();
            dist[p[0]][p[1]] = p[2];
            for(int i=0; i<4; i++){
                int nr = dir[i][0] + p[0];
                int nc = dir[i][1] + p[1];
                if(nr>=0 && nr<n && nc>=0 && nc<m && vis[nr][nc]==0 && mat[nr][nc] == 1){
                    vis[nr][nc] = 1;
                    q.offer(new int[] {nr,nc, p[2]+1});
                }
            }
        }
        return dist;
    }
   
}