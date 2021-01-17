import org.junit.Test;

public class Leetcode_1588 {
    public int sumOddLengthSubarrays(int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            int left = i + 1;
            int right = arr.length - (i + 1) + 1;

            int left_odd = left / 2;
            int left_even = (left + 1) / 2;
            int right_odd = right / 2;
            int right_even = (right + 1) / 2;
            sum += (left_odd * right_odd + left_even * right_even) * arr[i];
        }
        return sum;
    }

    @Test
    public void test() {
        System.out.println(3 / 2);
    }
}
