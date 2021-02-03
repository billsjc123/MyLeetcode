import org.junit.Test;

public class Leetcode_59 {
    public int[][] generateMatrix(int n) {
        int cnt = 1;
        int ceil = 0, right = n - 1, floor = n - 1, left = 0;
        int[][] ans = new int[n][n];
        int i = 0, j = 0;
        while (cnt < n * n) {
            // 向右移动
            for (j = left; j <= right; j++) {
                ans[i][j] = cnt++;
            }
            ceil++;
            // 向下移动
            for (i = ceil; i <= floor; i++) {
                ans[i][j] = cnt++;
            }
            right++;
            // 向左移动
            for (j = right; j >= left; j--) {
                ans[i][j] = cnt++;
            }
            floor++;
            // 向上移动
            for (i = floor; i >= ceil; i--) {
                ans[i][j] = cnt++;
            }
            left++;
            
        }
        return ans;
    }

    @Test
    public void test() {
        generateMatrix(3);
    }
}
