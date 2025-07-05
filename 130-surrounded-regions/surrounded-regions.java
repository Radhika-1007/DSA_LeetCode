class Solution {
    public void solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;
        int vis[][] = new int[n][m];
        int dir[][] = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};
        //for first and last row
       for(int j = 0; j<m; j++){
            //first row
            if(vis[0][j] == 0 && board[0][j] == 'O'){
                dfs(vis, board, 0, j, dir);
            }
            //last row
            if(vis[n-1][j] == 0 && board[n-1][j] == 'O'){
                dfs(vis, board, n-1, j, dir);
            }
       }
       for(int i = 0; i<n; i++){
            //first column
            if(vis[i][0] == 0 && board[i][0] == 'O'){
                dfs(vis, board, i, 0, dir);
            }
            //last column
            if(vis[i][m-1] == 0 && board[i][m-1] == 'O'){
                dfs(vis, board, i, m-1, dir);
            }
       }
       for(int i=0; i<n; i++){
        for(int j=0; j<m; j++){
            if(vis[i][j]==0){
                board[i][j]='X';
            }
            else{
                board[i][j]='O';
            }
        }
       }
    }
    private void dfs(int vis[][], char[][] board, int r, int c, int dir[][]){
        vis[r][c] = 1;
        for(int i=0; i<4; i++){
            int nr = dir[i][0] + r;
            int nc = dir[i][1] + c;
            if(nr>=0 && nr<board.length && nc>=0 && nc<board[0].length && board[nr][nc] == 'O' && vis[nr][nc] == 0){
                dfs(vis, board, nr, nc, dir);
            }
        }
    }
}