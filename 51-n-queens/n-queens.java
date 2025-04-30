class Solution {
    public List<List<String>> solveNQueens(int n) {
        char board[][] = new char[n][n];
        for(int i = 0; i<n; i++){
            for(int j = 0; j<n; j++){
                board[i][j] = '.';
            }
        }
        List<List<String>> res = new ArrayList<List<String>>();
        int leftrow[] = new int[n];
        int upperdiagonal[] = new int[2*n -1];
        int lowerdiagonal[] = new int[2*n - 1];
        solve(0, res, board, leftrow, upperdiagonal, lowerdiagonal);
        return res;
    };
    private static void solve(int col, List<List<String>> res, char board[][], int lr[], int ud[], int ld[]){
        if(col == board.length){
            res.add(construct(board));
            return;
        }
        for(int i = 0; i<board.length; i++){
            if(lr[i] == 0 && ud[i + col] == 0 && ld[board.length - 1 + col - i] == 0){
                board[i][col] = 'Q';
                lr[i] = 1;
                ud[i + col] = 1;
                ld[board.length - 1 + col - i] = 1;
                solve(col+1, res, board, lr, ud, ld);
                board[i][col] = '.';
                lr[i] = 0;
                ud[i + col] = 0;
                ld[board.length - 1 + col - i] = 0;
            }
        }
    }
        private static List<String> construct(char[][] board) {
        List < String > res = new ArrayList < String > ();
        for (int i = 0; i < board.length; i++) {
            String s = new String(board[i]);
            res.add(s);
        }
        return res;
    }
}