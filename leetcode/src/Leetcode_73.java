import org.junit.Test;

public class Leetcode_73 {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        int zeroCol = 0;
        
        for (int i = 0; i < m; i++) {
            if (matrix[i][0] == 0) {
                zeroCol = -1;
            }
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = -1;
                    matrix[0][j] = -1;
                }
            }
        }

        for (int i = m-1; i >=1 ; i--) {
            if (matrix[i][0] == -1) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = 0;
                }
            }
        }
        for (int j = n-1; j >0; j--) {
            if (matrix[0][j] == -1) {
                for (int i = 0; i < m; i++) {
                    matrix[i][j] = 0;
                }
            }
        }
        if (matrix[0][0] == -1) {
            for (int i = 0; i < n; i++) {
                matrix[0][i] = 0;
            }
        }
        if (zeroCol == -1) {
            for (int i = 0; i < m; i++) {
                matrix[i][0] = 0;
            }
        }
    }

    @Test
    public void test(){
        int [][]matrix = new int[][]{{0,1,2,0},{1,1,1,1},{1,1,1,1}};
        setZeroes(matrix);
    }
}
