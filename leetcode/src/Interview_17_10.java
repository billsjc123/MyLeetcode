import java.util.Arrays;

public class Interview_17_10 {
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);

        int max = 1;
        int cnt = 1;
        for (int i = 0; i < nums.length-1; i++) {
            if (nums[i] == nums[i + 1])
            {
                cnt++;
                max=Math.max(cnt,max);
            }
            else
            {
                cnt = 1;
            }
            if(max>nums.length/2)
            {
                return nums[i];
            }
        }
        return -1;
    }
}
