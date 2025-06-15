class Solution {
    class Pair{
        int first;
        int second;
        Pair(int f, int s){
            first = f;
            second = s;
        }
    }
    private void bfs(char[][] grid, int vis[][], int row, int col){
        int n = grid.length;
        int m = grid[0].length;
        Queue<Pair> q =  new LinkedList<Pair>();
        vis[row][col] = 1;
        q.add(new Pair(row, col));
        int drow[] = {-1, 0, 1, 0};
        int dcol[] = {0, 1, 0, -1};
        while(!q.isEmpty()){
            int ro = q.peek().first;
            int co = q.peek().second;
            q.poll();
            for(int i=0; i<4; i++){
                int nr = ro + drow[i];
                    int nc = co + dcol[i];
                    if(nr >= 0 && nr < n && nc >= 0 && nc < m && grid[nr][nc] == '1' && vis[nr][nc] == 0){
                        vis[nr][nc] = 1;
                        q.add(new Pair(nr, nc));
                    }        
                
            }
        }    

    }
    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int count = 0;
        int vis[][] = new int[n][m];
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(vis[i][j] == 0 && grid[i][j] == '1'){
                    bfs(grid, vis, i, j);
                    count++;
                }
            }
        }
        return count;
    }
}