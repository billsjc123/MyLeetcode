import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class Leetcode_15 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        if (nums.length < 3)
            return ans;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length && nums[i] <= 0; i++) {
            int j = i + 1, k = nums.length - 1;
            while (j < k) {
                if (nums[j] + nums[k] > -nums[i]) {
                    while(nums[k]==nums[k-1])k--;
                } else if (nums[j] + nums[k] == -nums[i]) {
                    ans.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    j++;
                    k--;
                } else{
                    while(nums[j]==nums[j+1])j++;
                }
            }
        }

        return ans;
    }

    @Test
    public void test1(){
        Leetcode_15 l = new Leetcode_15();
        l.threeSum(new int[]{-1,0,1,2,-1,-4});
    }
}

class test{
    @Test
    public void test1(){
        Leetcode_15 l = new Leetcode_15();
        l.threeSum(new int[]{-1,0,1,2,-1,-4});
    }
}
