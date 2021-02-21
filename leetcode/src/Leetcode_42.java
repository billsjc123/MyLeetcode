import java.util.Stack;

import org.junit.Test;

public class Leetcode_42 {
    public int trap(int[] height) {
        int ans = 0;

        Stack<Integer> s = new Stack<Integer>(); // 维护一个单调递减栈
        int i = 0;
        while (height[i] == 0)
            i++;
        for (; i < height.length; i++) {
            while (!s.isEmpty() && height[s.peek()] < height[i]) {
                int left = s.pop();
                if (s.isEmpty())
                    break;
                int boundedHeight = Math.min(height[s.peek()], height[i]);
                ans += (i - s.peek() - 1) * (boundedHeight - height[left]);
            }
            s.push(i);
        }
        return ans;
    }

    @Test
    public void test() {
        System.out.println(trap(new int[] { 4, 2, 0, 3, 2, 5 }));
    }
}
