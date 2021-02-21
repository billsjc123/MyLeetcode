import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

public class Leetcode_1386 {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        Integer b2to5 = 0b11110000;         // 如果2~5没有预定则得到的bits为xxxx0000，与b2to5按位或的结果一定为b2to5
        Integer b4to7 = 0b11000011;
        Integer b6to9 = 0b00001111;

        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

        for (int[] r : reservedSeats) {
            if (r[1] == 1 || r[1] == 10) {
                continue;
            }
            Integer bits = map.getOrDefault(r[0], 0);
            // 从右边开始表示座位2~9
            bits |= 1 << (r[1] - 2);
            map.put(r[0], bits);
        }

        // 如果该行没有任何预定，一定可以包含两个4人位
        // 如果有任何一个预定都只能放一个4人位了
        int ans = (n - map.size()) * 2;
        for (Map.Entry entry : map.entrySet()) {
            Integer bits = (Integer) entry.getValue();
            if ((bits | b2to5) == b2to5 || (bits | b4to7) == b4to7 || (bits | b6to9) == b6to9) {
                ans++;
            }
        }

        return ans;

    }

    @Test
    public void test() {
        System.out.println(0b00001111 | 0b00010000);
    }
}
