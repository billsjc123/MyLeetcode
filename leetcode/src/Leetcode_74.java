import java.lang.annotation.Target;

import org.junit.Test;
public class Leetcode_74 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;

        // ±ß½ç¼ì²â
        if (target > matrix[m - 1][n - 1] || target < matrix[0][0])
            return false;

        int l = 0, r = m * n - 1;
        while (l <= r) {
            int mid = (l + r) >> 1;
            int row = mid / n;
            int col = mid % n;
            int val = matrix[row][col];
            if (val < target) {
                l = mid + 1;
            } else if (val == target) {
                return true;
            } else {
                r = mid - 1;
            }
        }
        return false;
    }

    @Test
    public void test() {
        int[][] arr = new int[][] { { 1, 3, 5, 7 }, { 10, 11, 16, 20 }, { 23, 30, 34, 60 } };
        System.out.println(searchMatrix(arr, 3));
        System.out.println(searchMatrix(arr, 0));
        System.out.println(searchMatrix(arr, 30));

    }
}
