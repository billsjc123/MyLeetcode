import java.util.Arrays;

public class Interview_16_06 {
    public int smallestDifference(int[] a, int[] b) {
        int ans = Integer.MIN_VALUE;
        Arrays.sort(a);
        Arrays.sort(b);

        int i = 0, j = 0;
        if (a[i] > b[j]) {
            while (j < b.length - 1 && b[j + 1] < a[i])
                j++;
            ans = Math.max(ans, -Math.abs(a[i] - b[j]));
        }
        while (i < a.length && j < b.length) {
            while (i < a.length - 1 && a[i + 1] < b[j])
                i++;
            ans = Math.max(-Math.abs(a[i] - b[j]), ans);
            i++;
            if (i == a.length)
                break;
            while (j < b.length - 1 && b[j + 1] < a[i])
                j++;
            ans = Math.max(-Math.abs(a[i] - b[j]), ans);
            j++;
        }
        return Math.abs(ans);
    }
}
