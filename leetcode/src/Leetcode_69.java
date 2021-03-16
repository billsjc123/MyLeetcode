public class Leetcode_69 {
    public static int mySqrt(int x) {
        int l = 0, r = x;
        while(l<=r){
            int m = l + (r-l)/2;
            long temp = (long)m*m;
            if(temp == x)return m;
            else if(temp<x)l=m+1;
            else r=m-1;
        }
        return r;
    }

    public static void main(String[] args) {
        mySqrt(2147483647);
    }
}
