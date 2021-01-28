public class Leetcode_581 {
    public int findUnsortedSubarray(int[] nums) {
        int len = nums.length;
        if (len <= 1)
            return 0;

        int min[] = new int[len];
        int max[] = new int[len];

        min[len - 1] = nums[len - 1];
        max[0] = nums[0];
        for (int i = 1; i < max.length; i++) {
            max[i] = nums[i] > max[i - 1] ? nums[i] : max[i - 1];
            min[len - 1 - i] = nums[len - 1 - i] < min[len - i] ? nums[len - 1 - i] : min[len - i];
        }
        int l = 0, r = len - 1;
        while (l < len - 1 && nums[l] < min[l + 1])
            l++;
        while (r > 0 && nums[r] > max[r - 1])
            r--;
        return r - l + 1 > 1 ? r - l + 1 : 0;
    }
}
