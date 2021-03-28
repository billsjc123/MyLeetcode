import java.util.ArrayList;

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
    public int lengthOfLIS(int[] arr) {
        ArrayList<Integer> upperList = new ArrayList<Integer>();
        for(int num:arr){
            if(num>upperList.get(upperList.size()-1)){
                upperList.add(num);
            }else{
                // 找到第一个>=num的进行替换
                int swapIdx = binarySearch(upperList,num);
                upperList.set(swapIdx, num);
            }
        }
        return upperList.size();
    }

    public int binarySearch(ArrayList<Integer> arr,int target){
        int l = 0, r = arr.size()-1;
        while(l<r){
            int m = l+(r-l)/2;
            if(arr.get(m)<target){
                l=m+1;
            }else if(arr.get(m)==target){
                return m;
            }else{
                r=m;
            }
        }
        return r;
    }
}
