import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Leetcode_18 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ans = new LinkedList<List<Integer>>();

        Arrays.sort(nums);
        if (nums.length < 4 || nums[0] > target)
            return ans;
        for (int i = 0; i < nums.length - 3; i++) {
            if (nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3] > target)
                break;
            if (nums[i] + nums[nums.length - 3] + nums[nums.length - 2] + nums[nums.length - 1] < target)
                continue;
            if (i > 0 && nums[i] == nums[i - 1])
                continue;
            for (int j = i + 1; j < nums.length - 2; j++) {
                if (j > i + 1 && nums[j - 1] == nums[j])
                    continue;
                int l = j + 1, r = nums.length - 1;
                while (l < r) {
                    int sum = nums[i] + nums[j] + nums[l] + nums[r];
                    if (sum > target) {
                        while (l < r && nums[r] == nums[r - 1])
                            r--;
                        r--;
                    } else if (sum < target) {
                        while (l < r && nums[l] == nums[l + 1])
                            l++;
                        l++;
                    } else {
                        ans.add(Arrays.asList(nums[i], nums[j], nums[l], nums[r]));
                        while (l < r && nums[l] == nums[l + 1])
                            l++;
                        while (l < r && nums[r] == nums[r - 1])
                            r--;
                        l++;
                        r--;
                    }
                }
            }
        }
        return ans;
    }
}
