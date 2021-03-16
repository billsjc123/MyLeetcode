import java.util.Comparator;
import java.util.PriorityQueue;

public class Leetcode_239 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] ans = new int[nums.length-k+1];
        
        PriorityQueue<int []> priorityQueue = new PriorityQueue<int []>(new Comparator<int[]>(){
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]!=o2[0]?o2[0]-o1[0]:o2[1]-o2[1];
            }
        });
        
        for(int i=0;i<k;i++){
            priorityQueue.offer(new int[]{nums[i],i});
        }
        ans[0]=priorityQueue.peek()[0];
        
        for(int i=k;i<nums.length;i++){
            while(!priorityQueue.isEmpty() && priorityQueue.peek()[1]<=i-k){
                priorityQueue.poll();
            }
            priorityQueue.offer(new int[]{nums[i],i});
            ans[i-k+1]=priorityQueue.peek()[0];
        }

        return ans;
    }
}
