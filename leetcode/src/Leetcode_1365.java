public class Leetcode_1365 {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] freq = new int[101];
        int[] preSum = new int[101];

        for (int i : nums) {
            freq[i]++;
        }
        for (int i = 1; i < preSum.length; i++) {
            preSum[i] += preSum[i - 1] + freq[i - 1];
        }

        for (int i = 0; i < nums.length; i++) {
            nums[i] = preSum[nums[i]];
        }
        return nums;
    }
}
