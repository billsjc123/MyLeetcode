import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class Leetcode_1260 {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;

        // 去除重复操作
        k %= m * n;

        // 行偏移和列偏移
        int row_bias = k / n;
        int col_bias = k % n;

        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        int x, y;
        if (col_bias != 0) {
            x = m - 1 - row_bias;
            y = n - col_bias;
        } else {
            x = m - row_bias;
            y = 0;
        }
        int cnt = 0;
        while (cnt < m * n) {
            List<Integer> new_row = new ArrayList<Integer>();
            for (int i = 0; i < n; i++) {
                new_row.add(grid[x][y]);
                if (y == n - 1) {
                    if (x == m - 1) {
                        x = 0;
                        y = 0;
                    } else {
                        x++;
                        y = 0;
                    }
                } else {    
                    y++;
                }
                cnt++;
            }
            ans.add(new_row);
        }
        return ans;
    }

    @Test
    public void test() {
        int[][] arr = new int[][] { { 3, 8, 1, 9 }, { 19, 7, 2, 5 }, { 4, 6, 11, 10 }, { 12, 0, 21, 13 } };
        shiftGrid(arr, 4);
    }
}
