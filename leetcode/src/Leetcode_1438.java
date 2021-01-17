import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.Test;

public class Leetcode_1438 {
    public int longestSubarray(int[] nums, int limit) {
        int maxlen=0;
        int l = 0,r = 0;

        List<Integer> arr = new ArrayList<Integer>();
        arr.add(nums[l]);
        
        while(r<nums.length){
            int min = Collections.min(arr);
            int max = Collections.max(arr);
            
            if(max-min>limit){
                arr.remove(Integer.valueOf(nums[l]));
                l++;
            }else{
                r++;
                if(r<nums.length)
                    arr.add(nums[r]);
            }

            maxlen=Math.max(maxlen, arr.size());
        }
        return maxlen;
    }

    @Test
    public void test1(){
        System.out.println(longestSubarray(new int[]{8,2,4,7}, 4));
    }
}
