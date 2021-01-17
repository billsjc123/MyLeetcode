public class Leetcode_11 {
    public int maxArea(int[] height) {
        int l = 0,r = height.length-1;
        int max = 0;
        while(l<r){
            int h = Math.min(height[l],height[r]);
            max = Math.max(max, (l-r)*h);
            while(height[l]<=h && l<r)l++;
            while(height[r]<=h && l<r)r--;
        }
        return max;
    }
}
