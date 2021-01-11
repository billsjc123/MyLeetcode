import java.util.Arrays;

public class Leetcode_1552 {
    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        int left = 1, right = position[position.length - 1] - position[0], ans = -1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (check(position, mid, m)) {
                ans = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return ans;
    }

    public boolean check(int[] position, int minInterval, int m) {
        int cnt = 1;
        int pre = position[0];
        for (int i = 1; i < position.length; i++) {
            if (position[i] - pre >= minInterval) {
                cnt++;
                pre=position[i];
            }
        }
        return cnt >= m;
    }
}
