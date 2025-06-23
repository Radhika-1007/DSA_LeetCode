class Solution {
    class Node{
        int r;
        int c;
        int l;
        Node(int r, int c, int l){
            this.r = r ;
            this.c = c;
            this.l = l;
        }
    }
    public int[][] updateMatrix(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        int vis[][] = new int[n][m];
        int dist[][] = new int[n][m];
        Queue<Node> q = new LinkedList<>();
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(mat[i][j] == 0){
                    q.add(new Node(i, j, 0));
                    vis[i][j] = 1;
                }
                else{
                    vis[i][j] = 0;
                }
            }
        }
        int dr[] = {-1, 0, 1, 0};
        int dc[] = {0, 1, 0, -1};
        while(!q.isEmpty()){
            int row = q.peek().r;
            int col = q.peek().c;
            int steps = q.peek().l;
            q.poll();
            dist[row][col] = steps;
            for(int i=0; i<4; i++){
                int nr = row + dr[i];
                int nc = col + dc[i];
                if(nr>=0 && nr<n && nc>=0 && nc<m && vis[nr][nc] == 0){
                    vis[nr][nc] = 1;
                    q.add(new Node(nr, nc, steps+1));
                }
            }
        }
        return dist;
    }
}