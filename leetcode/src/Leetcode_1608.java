import java.util.Arrays;

public class Leetcode_1608 {
    public int specialArray(int[] nums) {
        int len = nums.length;
        int cnt = 0;
        int idx = len - 1;
        Arrays.sort(nums);
        for (int i = len; i > 0; i--) {
            while (idx >= 0 && nums[idx] >= i) {
                cnt++;
                idx--;
            }
            if (cnt == i) {
                return i;
            } else if (cnt > i) {
                break;
            }
        }
        return -1;
    }
}
