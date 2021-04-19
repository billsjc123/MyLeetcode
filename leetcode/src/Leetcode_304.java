public class Leetcode_304 {
    static class NumMatrix {
        int[][] prefix;
        public NumMatrix(int[][] matrix) {
            prefix = new int[matrix.length][matrix[0].length];
    
            prefix[0][0]=matrix[0][0];
            for(int i=1;i<matrix.length;i++){
                prefix[i][0]=prefix[i-1][0]+matrix[i][0];
            }
            for(int j=1;j<matrix[0].length;j++){
                prefix[0][j]=prefix[0][j-1]+matrix[0][j];
            }
    
            for(int i=1;i<matrix.length;i++){
                for(int j=1;j<matrix[0].length;j++){
                    prefix[i][j]=prefix[i-1][j]+prefix[i][j-1]-prefix[i-1][j-1]+matrix[i][j];
                }
            }
        }
        
        public int sumRegion(int row1, int col1, int row2, int col2) {
            int left = col1==0?0:prefix[row2][col1-1];
            int up = row1==0?0:prefix[row1-1][col2];
            int left_up = row1>0 && col1>0 ? prefix[row1-1][col1-1]:0;
            return prefix[row2][col2]-left-up+left_up;
        }
    }
    public static void main(String[] args) {
        int[][] matrix = new int[][]{
            {3, 0, 1, 4, 2},
            {5, 6, 3, 2, 1},
            {1, 2, 0, 1, 5},
            {4, 1, 0, 1, 7},
            {1, 0, 3, 0, 5}
        };
        NumMatrix nm = new NumMatrix(matrix);
        nm.sumRegion(2, 1, 4, 3);
    }
}
