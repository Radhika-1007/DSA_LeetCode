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
        Queue<Pair> q = new LinkedList<>();
        if(grid[0][0] == 1|| grid[n-1][n-1] == 1) return -1;
        q.offer(new Pair(0,0));
        int vis[][] = new int[n][n];
        vis[0][0] = 1;
        int count = 1;
        int dir[][] = {{-1,-1},{-1,1}, {1,1},{-1,0}, {0,1}, {1,0}, {1,-1}, {0, -1}};
        while(!q.isEmpty()){
            int size = q.size();
            for(int j=0; j<size; j++){
            Pair p = q.poll();
            int r = p.row;
            int c = p.col;
            if(r==n-1 && c==n-1) return count;
            for(int i=0; i<8; i++){
                int nr =r+ dir[i][0];
                int nc = c+dir[i][1];
                if(nr>=0 && nr<n && nc>=0 && nc<n && grid[nr][nc]==0 && vis[nr][nc] == 0){                 
                    vis[nr][nc] = 1;
                    q.add(new Pair(nr,nc));
                }
            }
            }
             count++;
        }
        return -1;
    }
}