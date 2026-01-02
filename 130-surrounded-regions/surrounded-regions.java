class Solution {
    public void solve(char[][] board) {
        int n = board.length, m = board[0].length;
        int vis[][] = new int[n][m];
        int dir[][] = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};
        for(int j=0; j<m; j++){
            //first row
            if(vis[0][j] == 0 && board[0][j] == 'O'){
                dfs(0, j, board, vis, dir);
            }
            //last row
            if(vis[n-1][j] == 0 && board[n-1][j] == 'O'){
                dfs(n-1, j, board, vis, dir);
            }
        }
        for(int i=0; i<n; i++){
            //first column
            if(vis[i][0] == 0 && board[i][0] == 'O'){
                dfs(i, 0, board, vis, dir);
            }
            //last column
            if(vis[i][m-1] == 0 && board[i][m-1] == 'O'){
                dfs(i, m-1, board, vis, dir);
            }
        }
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(vis[i][j] == 1 && board[i][j] == 'O'){
                    board[i][j] = 'O';
                }
                else board[i][j] = 'X';
            }
        }
    }
    public void dfs(int i, int j, char board[][], int vis[][], int dir[][]){
        vis[i][j] = 1;
        for(int d=0; d<4; d++){
            int nr = i + dir[d][0];
            int nc = j + dir[d][1];
            if(nr>=0 && nr<board.length && nc>=0 && nc<board[0].length && vis[nr][nc] == 0 && board[nr][nc] == 'O'){
                dfs(nr, nc, board, vis, dir);
            }
        }
    }
}