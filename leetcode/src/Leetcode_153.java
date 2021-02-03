public class Leetcode_153 {
    public int findMin(int[] nums) {
        int len = nums.length;
        int l = 0, r = len - 1;
        while (l<r) {
            int m = (l + r) >> 1;
            if (nums[m] > nums[r]) {
                l = m + 1;
            } else {
                r = m;
            }
        }
        return nums[r];
    }
}
