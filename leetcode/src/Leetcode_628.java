public class Leetcode_628 {
    public int maximumProduct(int[] nums) {
        int max1=0,max2=0,max3=0;
        int min1=1001,min2=1001;
        for (int i : nums) {
            if(i<min1){
                min2 = min1;
                min1 = i;
            }else if(i<min2){
                min2 = i;
            }else if(i>max1){
                max3 = max2;
                max2 = max1;
                max1 = i;
            }else if(i>max2){
                max3 = max2;
                max2 = i;
            }else if(i>max3){
                max3 = i;
            }
        }
        return Math.max(max1*max2*max3,min1*min2*max1);
    }
}
