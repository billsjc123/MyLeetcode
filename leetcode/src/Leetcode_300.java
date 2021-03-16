public class Leetcode_300 {
    // dp O(n^2)
    // public int lengthOfLIS(int[] nums) {
    //     int dp[] = new int[nums.length];
    //     dp[0]=1;
    //     int ans = 1;

    //     for(int i=1;i<nums.length;i++){
    //         dp[i]=1;
    //         for(int j=i-1;j>=0;j--){
    //             if(nums[i]>nums[j]){
    //                 dp[i]=Math.max(dp[i],dp[j]+1);
    //             }
    //         }
    //         ans = Math.max(ans,dp[i]);
    //     }
    //     return ans;
    // }

    // greedy
    // public int lengthOfLIS(int[] nums) {
        
    // }
}
