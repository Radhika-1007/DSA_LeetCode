class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int startRow = 0;
        int endRow = n-1;
        int startCol = 0;
        int endCol = m-1;
        int tne = m*n;
        int count = 0;
        List<Integer> result = new ArrayList<>();
        while(startRow <= endRow && startCol <= endCol){
            //top;
            for(int j = startCol; j<=endCol && count < tne; j++){
                result.add(matrix[startRow][j]);
                count++;
            }
            startRow++;
            //right
            for(int i = startRow; i<=endRow && count < tne; i++){
                result.add(matrix[i][endCol]);
                count++;
            }
            endCol--;
            //bottom
            for(int j = endCol; j>=startCol && count < tne; j--){
                result.add(matrix[endRow][j]);
                count++;
            }
            endRow--;
            //left
            for(int i = endRow ; i>=startRow  && count < tne; i--){
                result.add(matrix[i][startCol]);
                count++;
            }
            startCol++;
        }
        return result;
    }
}