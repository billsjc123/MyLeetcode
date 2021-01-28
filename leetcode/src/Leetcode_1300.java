import java.util.Arrays;
import java.util.Collection;

public class Leetcode_1300 {
    public int findBestValue(int[] arr, int target) {
        int sum = 0;
        int result = -1;
        Arrays.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            double avg = (double) (target - sum) / (arr.length - i);
            if (avg < arr[i]) {
                if (avg - Math.floor(avg) <= 0.5)
                    return (int) Math.floor(avg);
                else
                    return (int) Math.round(avg);
            }
            sum += arr[i];
        }
        return result;
    }
}
