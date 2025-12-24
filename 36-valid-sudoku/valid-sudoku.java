class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashSet<String> seen = new HashSet<>();
        for(int i=0; i<9; i++){
            for(int j=0; j<9; j++){
                if(board[i][j] == '.') continue;
                char c = board[i][j];
                if(!seen.add(c + "r" + i) || !seen.add(c + "c" + j) || !seen.add(c + "b" + ((i/3) * 3 + j/3))) return false;
                
            }
        } 
         return true;
    }
}