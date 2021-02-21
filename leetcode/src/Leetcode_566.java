public class Leetcode_566 {
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        int m = nums.length, n = nums[0].length;
        int cnt = 0;
        if (n * m != r *c) {
            return nums;
        }
        int[][] ans = new int[r][c];
        while (cnt < r * c) {
            ans[cnt / c][cnt % c] = nums[cnt / n][cnt % n];
            cnt++;
        }
        return ans;
    }
}
