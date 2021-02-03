import org.junit.Test;

public class Leetcode_59 {
    public int[][] generateMatrix(int n) {
        int cnt = 1;
        int ceil = 0, right = n - 1, floor = n - 1, left = 0;
        int[][] ans = new int[n][n];
        int i = 0, j = 0;
        while (cnt < n * n) {
            // �����ƶ�
            for (j = left; j <= right; j++) {
                ans[i][j] = cnt++;
            }
            ceil++;
            // �����ƶ�
            for (i = ceil; i <= floor; i++) {
                ans[i][j] = cnt++;
            }
            right++;
            // �����ƶ�
            for (j = right; j >= left; j--) {
                ans[i][j] = cnt++;
            }
            floor++;
            // �����ƶ�
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
