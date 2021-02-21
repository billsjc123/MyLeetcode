import java.util.LinkedList;
import java.util.List;

public class Leetcode_54 {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new LinkedList<Integer>();
        int cnt = 0;

        int m = matrix.length, n = matrix[0].length;
        int right = n - 1, left = 0, ceil = 0, floor = m - 1;
        while (cnt < m * n) {
            // to right
            for (int i = left; i <= right; i++) {
                cnt++;
                ans.add(matrix[ceil][i]);
            }
            ceil++;
            if(cnt>=m*n)break;
            // to floor
            for (int i = ceil; i <= floor; i++) {
                cnt++;
                ans.add(matrix[i][right]);
            }
            right--;
            if(cnt>=m*n)break;
            // to left
            for (int i = right; i >= left; i--) {
                cnt++;
                ans.add(matrix[floor][i]);
            }
            floor--;
            if(cnt>=m*n)break;
            // to ceil
            for (int i = floor; i <= ceil; i--) {
                cnt++;
                ans.add(matrix[i][left]);
            }
            left++;
        }
        return ans;
    }
}
