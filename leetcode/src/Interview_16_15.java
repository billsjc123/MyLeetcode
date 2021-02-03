public class Interview_16_15 {
    public int[] masterMind(String solution, String guess) {
        int s[] = new int[4];
        int g[] = new int[4];

        int ans[] = new int[2];
        for (int i = 0; i < g.length; i++) {
            if (solution.charAt(i) == guess.charAt(i)) {
                ans[0]++;
                continue;
            }
            helper(solution, i, s);
            helper(guess, i, g);
        }
        for (int i = 0; i < g.length; i++) {
            if (s[i] > 0 && g[i] > 0) {
                ans[1]++;
            }
        }
        return ans;
    }

    void helper(String str, int idx, int[] cnter) {
        if (str.charAt(idx) == 'R') {
            cnter[0]++;
        } else if (str.charAt(idx) == 'Y') {
            cnter[1]++;
        } else if (str.charAt(idx) == 'G') {
            cnter[2]++;
        } else if (str.charAt(idx) == 'B') {
            cnter[3]++;
        }
    }
}
