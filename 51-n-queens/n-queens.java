class Solution {
    public List<List<String>> solveNQueens(int n) {
        char board[][] = new char[n][n];
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                board[i][j] = '.';
            }
        }
        List<List<String>> res = new ArrayList<>();
        int leftrow[] = new int[n];
        int upperdiagonal[] = new int[2*n-1];
        int lowerdiagonal[] = new int[2*n-1];
        solve(0, res, board, leftrow, upperdiagonal, lowerdiagonal, n);
        return res;
        
    }
    public void solve(int col, List<List<String>> res, char board[][], int lr[], int ud[], int ld[], int n){
        if(col == board.length){
            res.add(construct(board));
        }
        for(int i=0; i<n; i++){
            if(lr[i] == 0 && ud[col + i] == 0 && ld[n-1+col-i] == 0){
                board[i][col] = 'Q';
                lr[i] = 1;
                ud[col+i] = 1;
                ld[n-1+col-i] = 1;
                solve(col+1, res, board, lr, ud, ld, n);
                board[i][col] = '.';
                lr[i] = 0;
                ud[col+i] = 0;
                ld[n-1+col-i] = 0;
            }
        }
    }
    public List<String> construct(char board[][]){
        List<String> row = new ArrayList<>();
        for(int i=0; i<board.length; i++){
            String s = new String(board[i]);
            row.add(s);
        }
        return row;
    }
}