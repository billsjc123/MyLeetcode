public class Leetcode_198 {
    public int rob(int[] nums) {
        if(nums.length==0)return 0;
        else if(nums.length==1)return nums[0];
        int lastlast=nums[0];
        int last=Math.max(nums[0],nums[1]);
        for(int i=2;i<nums.length;++i){
            int temp = last;
            last=Math.max(last,nums[i]+lastlast);
            lastlast = temp;
        }
        return last;
    }
}
