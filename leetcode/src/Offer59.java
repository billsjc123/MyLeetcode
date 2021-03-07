import java.util.Deque;
import java.util.LinkedList;

public class Offer59 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] ans = new int[nums.length-k+1];
        Deque<Integer> queue = new LinkedList<Integer>();
        for(int i=0;i<k;i++){
            while(!queue.isEmpty()&&queue.getLast()<nums[i]){
                queue.removeLast();
            }
            queue.offerLast(nums[i]);
            ans[i]=queue.getFirst();
        }

        for(int i=k;i<nums.length;i++){
            if(queue.getFirst()==nums[i-k]){
                queue.removeFirst();
            }
            while(!queue.isEmpty()&&queue.getLast()<nums[i]){
                queue.removeLast();
            }
            queue.offerLast(nums[i]);
            ans[i]=queue.getFirst();
        }

        return ans;
    }
}
