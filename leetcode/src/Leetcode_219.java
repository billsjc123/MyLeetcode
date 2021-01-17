import java.util.HashMap;

public class Leetcode_219 {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer,Integer> m = new HashMap<Integer,Integer>();
        int len = nums.length;
        if(len<=1)return false;

        for (int i = 0; i < nums.length; i++) {
            if(m.containsKey(nums[i]) && i-m.get(nums[i])<=k)return true;
            else m.put(nums[i], i);
        }
        return false;
    }
}
