public class Leetcode_283 {
    public void moveZeroes(int[] nums) {
        int nonZeroIdx = 0;
        int idx = 0;
        while (idx < nums.length) {
            if (nums[idx] != 0) {
                nums[nonZeroIdx] = nums[idx];
                nonZeroIdx++;
            }
            idx++;
        }

        for (int i = nonZeroIdx; i < nums.length; i++) {
            nums[i] = 0;
        }
    }
}
