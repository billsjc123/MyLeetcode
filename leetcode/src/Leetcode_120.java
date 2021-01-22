import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Leetcode_120 {
    public int minimumTotal(List<List<Integer>> triangle) {
        int m = triangle.size();
        int[] dp = new int[m];

        dp[0] = triangle.get(0).get(0);

        for (int i = 1; i < m; i++) {
            dp[0] = dp[0] + triangle.get(i).get(0);
            dp[i] = dp[i - 1] + triangle.get(i).get(i);
            for (int j = 1; j < i; j++) {
                dp[j] = Math.min(dp[j - 1], dp[j]) + triangle.get(i).get(j);
            }
        }

        int ans = dp[0];
        for (int i : dp) {
            ans = Math.min(i, ans);
        }
        return ans;
    }

}
