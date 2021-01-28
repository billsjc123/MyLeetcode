import org.junit.Test;

public class Leetcode_55 {
    public boolean canJump(int[] nums) {
        int len = nums.length;
        if (len == 0)
            return false;
        if (len == 1)
            return true;

        int rightmost = 0;
        for (int i = 0; i <= rightmost; i++) {
            rightmost = Math.max(rightmost, i + nums[i]);
            if (rightmost >= len - 1)
                return true;
        }
        return false;
    }

}
