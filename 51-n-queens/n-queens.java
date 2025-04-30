class Solution {
    public List<List<String>> solveNQueens(int n) {
        char board[][] = new char[n][n];
        for(int i = 0; i<n; i++){
            for(int j = 0; j<n; j++){
                board[i][j] = '.';
            }
        }
        List<List<String>> res = new ArrayList<List<String>>();
        dfs(board, res, 0);
        return res;
    }
    private void dfs(char board[][], List<List<String>> res, int col){
        int n = board.length;
        if(col == n){
            res.add(construct(board));
            return;
        }
        for(int row = 0; row<n; row++){
            if(validate(board, row, col)){
                board[row][col] = 'Q';
                dfs(board, res, col+1);
                board[row][col] = '.';
            }
        }
    }
    private boolean validate(char board[][], int row, int col){
        int srow = row;
        int scol = col;
        while(row >= 0 && col >= 0){
            if(board[row][col] == 'Q') return false;
            row--;
            col--;
        }
        row = srow;
        col = scol;
        while(col >= 0){
            if(board[row][col] == 'Q') return false;
            col--;
        }
        row = srow;
        col = scol;
        while(col >= 0 && row < board.length){
            if(board[row][col] == 'Q') return false;
            col--;
            row++;
        }
        return true;
    }
    private List<String> construct(char board[][]){
        List<String> res = new ArrayList<>();
        for(int i = 0; i<board.length; i++){
            String s = new String(board[i]);
            res.add(s);
        }
        return res;
    }
}