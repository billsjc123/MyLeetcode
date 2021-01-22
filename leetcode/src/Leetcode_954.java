import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Leetcode_954 {
    public boolean canReorderDoubled(int[] arr) {
        if (arr.length == 0)
            return true;
        Arrays.sort(arr);

        Queue<Integer> q = new LinkedList<Integer>();
        q.offer(arr[0]);
        for (int i = 1; i < arr.length; i++) {
            if (q.isEmpty()) {
                q.offer(arr[i]);
                continue;
            }
            int front = q.peek();
            if (front < 0) {
                if (arr[i] >= 0)
                    return false;
                if (arr[i] * 2 < front) {
                    q.offer(arr[i]);
                } else if (arr[i] * 2 == front) {
                    q.poll();
                } else {
                    return false;
                }
            } else {
                if (arr[i] < front * 2) {
                    q.offer(arr[i]);
                } else if (arr[i] == front * 2) {
                    q.poll();
                } else {
                    return false;
                }
            }

        }
        return q.isEmpty() ? true : false;
    }
}
