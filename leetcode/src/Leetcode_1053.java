public class Leetcode_1053 {
    public int[] prevPermOpt1(int[] arr) {
        int len = arr.length;
        if (len == 1)
            return arr;

        for (int i = len - 1; i > 0; i--) {
            if (arr[i] < arr[i - 1]) {
                int temp = arr[i];
                arr[i] = arr[i - 1];
                arr[i - 1] = temp;
                return arr;
            }
        }

        return arr;
    }
}
