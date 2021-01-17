public class Leetcode_997 {
    public int[] sortedSquares(int[] nums) {
        int[] result = new int[nums.length];
        int idx = 0;
        int minabs = 0;
        for (minabs = 0; minabs < result.length - 1 && Math.abs(nums[minabs]) >= Math.abs(nums[minabs + 1]); minabs++)
            ;
        int left = minabs - 1, right = minabs;
        while (left >= 0 && right <= result.length - 1) {
            if (Math.pow(nums[left], 2) > Math.pow(nums[right], 2)) {
                result[idx++] = (int) Math.pow(nums[right], 2);
                right++;
            } else {
                result[idx++] = (int) Math.pow(nums[left], 2);
                left--;
            }
        }
        while (left >= 0) {
            result[idx++] = (int) Math.pow(nums[left], 2);
            left--;
        }
        while (right <= result.length - 1) {
            result[idx++] = (int) Math.pow(nums[right], 2);
            right++;
        }

        return result;
    }
}