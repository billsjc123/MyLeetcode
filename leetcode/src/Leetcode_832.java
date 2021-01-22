public class Leetcode_832 {
    public int[][] flipAndInvertImage(int[][] A) {
        for (int i = 0; i < A.length; i++) {
            int l = 0, r = A[0].length - 1;
            while (l <= r) {
                int temp = A[i][l];
                A[i][l] = 1 - A[i][r];
                A[i][r] = 1 - temp;
                l++;
                r--;
            }
        }
        return A;
    }
}
