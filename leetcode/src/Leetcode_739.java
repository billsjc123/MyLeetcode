import java.util.Stack;

import org.junit.Test;

public class Leetcode_739 {
    public int[] dailyTemperatures(int[] T) {
        Stack<Integer> s = new Stack<Integer>();    //单调栈维护的是还没有找到等待天数的温度的下标
        int[] ans = new int[T.length];
        for (int i = 0; i < T.length; i++) {
            while (!s.isEmpty() && T[s.peek()] < T[i]) {
                int prevIndex = s.pop();
                ans[prevIndex] = i-prevIndex;
            }
            s.push(i);
        }
        return ans;
    }

    @Test
    public void test(){
        int[] ans = dailyTemperatures(new int[]{73, 74, 75, 71, 69, 72, 76, 73});
        for (int i = 0; i < ans.length; i++) {
            System.out.println(ans[i]);
        }
    }
}
