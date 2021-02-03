public class Leetcode_724 {
    public int pivotIndex(int[] nums) {
        int preSum[] = new int[nums.length];
        preSum[0] = nums[0];
        for (int i = 1; i < preSum.length; i++) {
            preSum[i] = preSum[i - 1] + nums[i];
        }

        int sum = preSum[nums.length - 1];
        for (int i = 0; i < preSum.length; i++) {
            // ÅÐ¶ÏÊý×éÁ½¶Ë
            if(i==0)
        }
    }
}
