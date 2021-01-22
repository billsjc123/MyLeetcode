public class Leetcode_849 {
    public int maxDistToClosest(int[] seats) {
        int ans=0,prev=-1;
        for (int i = 0; i < seats.length; i++) {
            if(seats[i]==1){
                if(prev == -1)ans = i;
                else ans = Math.max(ans, (i+prev)/2 - prev);
                prev=i;
            }
        }
        if(prev<seats.length){
            ans = Math.max(ans,(seats.length-prev)/2 - prev);
        }
        return ans;
    }
}
