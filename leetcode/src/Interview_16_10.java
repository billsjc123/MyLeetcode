import java.util.Arrays;

import org.junit.Test;

public class Interview_16_10 {
    public int maxAliveYear(int[] birth, int[] death) {
        int[] lives = new int[102]; // 每年新增或减少的人
        int[] preSum = new int[102]; // 该年生存人数
        for (int i = 0; i < birth.length; i++) {
            lives[birth[i] - 1900]++;
            lives[death[i] - 1900 + 1]--;
        }

        int max = lives[0], minYear = 0;
        preSum[0] = lives[0];
        for (int i = 1; i < preSum.length; i++) {
            preSum[i] = preSum[i - 1] + lives[i];
            if (preSum[i] > max) {
                max = preSum[i];
                minYear = i;
            }
        }
        return minYear;
    }

    @Test
    public void test() {
        int[] birth = new int[] { 1900, 1901, 1950 };
        int[] death = new int[] { 1948, 1951, 2000 };
        System.out.println(maxAliveYear(birth, death));
    }
}
