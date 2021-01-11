public class Leetcode_867 {
    public int[][] transpose(int[][] A) {
        int m = A.length;
        int n = A[0].length;

        int [][] result = new int [n][m];
        for (int j = 0; j < n; j++) {
            for (int i = 0; i < m; i++) {
                result[j][i] = A[i][j];
            }
        }
        return result;
    }
}
