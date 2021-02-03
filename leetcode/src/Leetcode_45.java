public class Leetcode_45 {
    public int jump(int[] nums) {
        int rightmost = 0;
        int len = nums.length;
        int ans = 0;
        int next = 0;
        if (len == 1)
            return 0;

        // 贪心，每次在该位置能到达的位置中，找到能到达最远位置的作为下一个位置
        for (int i = 0; i < len; i = next) {
            if (i + nums[i] >= len - 1)
                return ans + 1;
            for (int j = 1; j <= nums[i]; j++) {
                if (i + j + nums[i + j] > rightmost) {
                    rightmost = i + j + nums[i + j];
                    next = i + j;
                }
            }
            ans++;
        }
        return ans;
    }
}
