import java.util.Stack;

import org.junit.Test;

public class Leetcode_907 {
    public int sumSubarrayMins(int[] arr) {
        Stack<Integer> s = new Stack<Integer>();
        int[] lefts = new int[arr.length];
        int[] rights = new int[arr.length];
        long ans = 0;
        int MOD = 1_000_000_007;
        // 找左边第一个小于arr[i]的下标
        for (int i = 0; i < arr.length; i++) {
            while (!s.isEmpty() && arr[s.peek()] >= arr[i]) {
                s.pop();
            }
            if (s.isEmpty())
                lefts[i] = -1;
            else
                lefts[i] = s.peek();
            s.push(i);
        }
        s.clear();
        for (int i = arr.length - 1; i >= 0; i--) {
            while (!s.isEmpty() && arr[s.peek()] > arr[i]) {
                s.pop();
            }
            if (s.isEmpty())
                rights[i] = arr.length;
            else
                rights[i] = s.peek();
            s.push(i);
        }
        for (int i = 0; i < arr.length; i++) {
            ans += (long)arr[i] * (i - lefts[i]) % MOD * (rights[i] - i) % MOD;
            // System.out.println("pos " + i + "'s left&right is:" +
            // lefts[i]+","+rights[i]);
        }
        return (int) ans;
    }

    @Test
    public void test() {
        int ans = sumSubarrayMins(new int[] { 71, 55, 82, 55 });
        System.out.println(ans);
    }
}
