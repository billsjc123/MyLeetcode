public class Leetcode_605 {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int m = flowerbed.length;
        int cnt = 0;
        int prev = -1;
        for (int i = 0; i < flowerbed.length; i++) {
            if (flowerbed[i] == 1) {
                if (prev < 0)
                    cnt += i / 2;
                else
                    cnt += (i - prev - 2) / 2;
                prev = i;
            }
        }
        if (prev < 0) {
            cnt += (1+m) / 2;
        }
        else {
            cnt += (m - prev - 1) / 2;
        }

        return cnt >= n;

    }

}
