class Solution {
    public boolean exist(char[][] board, String word) {
    
        int dir[][] = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};

        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[0].length; j++){
                if(dfs(board, i, j, 0, word, dir)) return true;
            }
        }
        return false;
    }
    public boolean dfs(char board[][], int i, int j, int index, String word, int dir[][]){
        if(index == word.length()) return true;
        if(i<0 || i>=board.length || j<0 || j>=board[0].length || board[i][j] != word.charAt(index)) return false;
        char temp = board[i][j];
        board[i][j] = '#';
        for(int d=0; d<4; d++){
            int nr = i+dir[d][0];
            int nc = j+dir[d][1];
            if(dfs(board, nr, nc, index+1, word, dir)){
                board[i][j] = temp;
                return true;
            }
        }
        //backtrack
        board[i][j] = temp;
        return false;
    }
}