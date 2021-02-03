public class Leetcode_1493 {
    public int longestSubarray(int[] nums) {
        int max = -1;
        int lastZero = -1;
        int tmp = 0;
        for (int i = 0; i < nums.length; i++) {
            // 如果该位是1，必定可以和上一位所表示的子数组拼起来，长度+1
            if (nums[i] == 1) {
                tmp += 1;
            } else {
                // 如果是0，则可以连续的1的子数组是上一个0到该位置中间的所有1
                // 上一个0之前的所有1不可能拼接上了，因为至少需要删除两个0
                tmp = i - lastZero - 1;
                lastZero = i;       // 更新上一个0的位置
            }
            max = Math.max(tmp, max);
        }
        // 全为1的情况，至少也要删除一个
        return Math.min(max, nums.length - 1);
    }
}
