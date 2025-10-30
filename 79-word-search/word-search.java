class Solution {
    public boolean exist(char[][] board, String word) {
        int dir[][] = {{-1, 0}, {0,-1}, {0, 1}, {1,0}};
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[0].length; j++){
                if(dfs(board, i, j, 0, dir, word)) return true;
            }
        }
        return false;
    }
    public boolean dfs(char board[][], int row, int col, int index, int dir[][], String word){
        if(index == word.length()) return true;
        if(row<0 || col<0 || row>=board.length || col>=board[0].length || board[row][col] != word.charAt(index)) return false;
        char temp = board[row][col];
        board[row][col] = '#';
        for(int i=0; i<4; i++){
            int nr = row + dir[i][0];
            int nc = col + dir[i][1];
            if(dfs(board, nr, nc, index+1, dir, word)){
                //restore
                board[row][col] = temp;
                return true;
            }
        }
        //backtack
        board[row][col] = temp;
        return false;
    }
}