import org.junit.Test;

public class Leetcode_945 {
    public int minIncrementForUnique(int[] A) {
        int cnter[] = new int[40001];
        int max = 0, ans = 0;
        for (int i : A) {
            cnter[i]++;
            max = Math.max(i, max);
        }

        for (int i = 0; i <= max; i++) {
            if (cnter[i] > 1) {
                int d = cnter[i] - 1;
                ans += d;
                cnter[i + 1] += d;
            }
        }
        if (cnter[max + 1] > 1) {
            int d = cnter[max + 1] - 1;
            ans += (1 + d) * d / 2;
        }
        return ans;
    }

    @Test
    public void test1() {
        int arr[] = new int[] { 3, 2, 1, 2, 1, 7 };
        System.out.println(minIncrementForUnique(arr));
    }
}
