class Pair{
    int row, col;
    Pair(int r, int c){
        row = r;
        col = c;
    }
}
class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        int dir[][] = {{-1,0}, {-1,-1}, {0,-1}, {1,-1}, {1,0}, {1,1}, {0,1}, {-1,1}};
        int vis[][] = new int[n][n];
        Queue<Pair> q = new LinkedList<>();
        if(grid[0][0] == 1 || grid[n-1][n-1] == 1) return -1;
        q.offer(new Pair(0, 0));
        vis[0][0] = 1;
        int path = 1;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0; i<size; i++){
                Pair p = q.poll();
                int r = p.row;
                int c = p.col;
                if(r == n-1 && c == n-1) return path;
                for(int d=0; d<8; d++){
                    int nr = dir[d][0] + r;
                    int nc = dir[d][1] + c;
                    if(nr>=0 && nr<n && nc>=0 && nc<n && grid[nr][nc] == 0 && vis[nr][nc] == 0){
                        q.offer(new Pair(nr, nc));
                        vis[nr][nc] = 1;
                    }
                }
            }
             path++;
        }
        return -1;
    }
}