import java.util.HashSet;

public class Leetcode_287 {
    public int findDuplicate(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int num = Math.abs(nums[i]);
            if(nums[num]>0)nums[num]=-nums[num];
            else return num;            
        }
        return -1;
    }
}