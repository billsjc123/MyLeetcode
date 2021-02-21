public class Leetcode_1051 {
    public int heightChecker(int[] heights) {
        int freq[] = new int[101];
        int ans = 0;
        for (int i : heights) {
            freq[i]++;
        }

        int h_idx = 0;
        for (int i = 0; h_idx < heights.length && i < freq.length; i++) {
            while (freq[i] > 0) {
                if (heights[h_idx] != i) {
                    ans++;
                }
                h_idx++;
                freq[i]--;
            }
        }
        return ans;
    }
}
