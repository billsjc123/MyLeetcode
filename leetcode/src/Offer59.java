import java.util.Deque;
import java.util.LinkedList;

public class Offer59 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums.length==0)return new int[]{};
        int r = 0;
        int[] ans = new int[nums.length-k+1];
        int idx = 0;
        Deque<Integer> deque = new LinkedList<Integer>(); 
        // 确定第一个窗口
        while(r<k){
            while(r>0 && !deque.isEmpty() && nums[r]>deque.getLast()){
                deque.removeLast();
            }
            deque.addLast(nums[r]);
            r++;
        }
        ans[idx++]=deque.peek();
        while(r<nums.length){
            // 移出滑动窗口的元素等于队首元素
            if(deque.peek()==nums[r-k]){
                deque.poll();
            }

            while(!deque.isEmpty() && nums[r]>deque.getLast()){
                deque.removeLast();
            }
            deque.addLast(nums[r]);
            r++;
            ans[idx++]=deque.peek();
        }
        return ans;
    }
}
