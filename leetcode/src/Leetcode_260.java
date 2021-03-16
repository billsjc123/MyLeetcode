public class Leetcode_260 {
    public int[] singleNumber(int[] nums) {
        int allXor = 0;
        for(int num:nums){
            allXor ^= num;
        }

        int findDiffBit=1;
        while((allXor & 1)==0){
            findDiffBit <<= 1;
            allXor >>>= 1;
        }

        int a=0,b=0;
        for(int num:nums){
           if((findDiffBit & num) == 0){
               a ^= num;
           }else{
               b ^= num;
           }
        }
        return new int[]{a,b};
    }
}
