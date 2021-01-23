import java.util.ArrayList;
import java.util.List;

public class Leetcode_442 {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> ans = new ArrayList<Integer>();
        for (int i = 0; i < nums.length; i++) {
            int num = Math.abs(nums[i]);

            nums[num-1]*=-1;
            if(nums[num-1]>0){
                ans.add(num);
            }
        }
        return ans;
    }
}
