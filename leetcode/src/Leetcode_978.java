public class Leetcode_978 {
    public int maxTurbulenceSize(int[] arr) {
        int[] oddUp = new int[arr.length];
        int[] evenUp = new int[arr.length];
        oddUp[0]=evenUp[0]=1;
        int ans=1;
        for(int i=1;i<arr.length;i++){
            // ż
            if(i%2==0){
                oddUp[i]=arr[i]<arr[i-1]?oddUp[i-1]+1:1;
                evenUp[i]=arr[i]>arr[i-1]?evenUp[i-1]+1:1;
            }else{
                oddUp[i]=arr[i]>arr[i-1]?oddUp[i-1]+1:1;
                evenUp[i]=arr[i]<arr[i-1]?evenUp[i-1]+1:1;
            }
            ans = Math.max(ans,Math.max(oddUp[i],evenUp[i]));
        }
        return ans;
    }
}
