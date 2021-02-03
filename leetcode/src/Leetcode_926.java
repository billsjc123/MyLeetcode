import org.junit.Test;

public class Leetcode_926 {
    public int minFlipsMonoIncr(String S) {
        int len = S.length();
        int prefix[] = new int[len + 1];
        int ans = Integer.MAX_VALUE;

        for (int i = 0; i < len; i++) {
            prefix[i + 1] = prefix[i] + (S.charAt(i) == '1' ? 1 : 0);
        }

        // 0~i-1全为0，i~len-1全为1
        for (int i = 0; i <= len; i++) {
            int tmp = prefix[i] + (len - i ) - (prefix[len] - prefix[i]);
            ans = Math.min(ans, tmp);
        }
        return ans;
    }

    @Test
    public void test() {
        System.out.println(minFlipsMonoIncr("00110"));
        System.out.println(minFlipsMonoIncr("010110"));
        System.out.println(minFlipsMonoIncr("00011000"));
    }
}
