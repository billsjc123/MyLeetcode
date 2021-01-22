public class Leetcode_1442 {
    public int countTriplets(int[] arr) {
        if (arr.length <= 2)
            return 0;
        int ans = 0;
        for (int i = 0; i < arr.length; i++) {
            int tmp = arr[i];
            for (int j = i + 1; j < arr.length; j++) {
                tmp ^= arr[j];
                if (tmp == 0)
                    ans += j - i;
            }
        }
        return ans;
    }
}
