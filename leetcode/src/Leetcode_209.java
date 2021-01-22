import org.junit.Test;

public class Leetcode_209 {
    public int minSubArrayLen(int s, int[] nums) {
        int len = nums.length;
        if (len == 0)
            return 0;

        int ans = len + 1;
        int l = 0, r = 0;
        int subSum = 0;
        while (r < len) {
            subSum += nums[r];
            while (subSum >= s) {
                ans = Math.min(r - l + 1, ans);
                subSum -= nums[l++];
            }
            r++;
        }
        return ans <= len ? ans : 0;
    }

    @Test
    public void test() {
        System.out.println(minSubArrayLen(4, new int[] { 1, 4, 4 }));
    }
}
