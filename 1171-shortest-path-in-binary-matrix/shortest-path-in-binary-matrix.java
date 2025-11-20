class Pair{
    int row, col;
    Pair(int r, int c){
        row = r;
        col = c;
    }
}
class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        if(grid[0][0] == 1 || grid[n-1][m-1] == 1) return -1;
        int dir[][] = {{-1,0}, {-1,1}, {0,1}, {1,1}, {1,0}, {1,-1}, {0,-1}, {-1,-1}};
        int vis[][] = new int[n][m];
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(0,0));
        vis[0][0] = 1;
        int count = 1;
        while(!q.isEmpty()){
            int size = q.size();
            for(int ele=0; ele<size; ele++){
                int r = q.peek().row;
                int c = q.peek().col;
                q.poll();
                if(r == n-1 && c == m-1) return count;
                for(int i=0; i<8; i++){
                    int nr = r + dir[i][0];
                    int nc = c +  dir[i][1];
                    if(nr>=0 && nr<n && nc>=0 && nc<m && vis[nr][nc] == 0 && grid[nr][nc] == 0){
                        q.offer(new Pair(nr, nc));
                        vis[nr][nc] = 1;
                    }
                }
            }
            count++;

        }
        return -1;
    }
}