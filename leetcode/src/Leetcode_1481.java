import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;

public class Leetcode_1481 {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

        for (int i : arr) {
            if (map.containsKey(i)) {
                map.put(i, map.get(i) + 1);
            } else {
                map.put(i, 1);
            }
        }

        List<int[]> freq = new LinkedList<int[]>();
        for (Entry<Integer, Integer> entry : map.entrySet()) {
            freq.add(new int[] { entry.getKey(), entry.getValue() });
        }

        Collections.sort(freq, new Comparator<int[]>() {
            public int compare(int[] arr1, int[] arr2) {
                return arr1[1] - arr2[1];
            }
        });

        int ans = freq.size();
        for (int i = 0; i < freq.size(); i++) {
            if (freq.get(i)[1] <= k) {
                k -= freq.get(i)[1];
                ans--;
            } else {
                break;
            }
        }

        return ans;
    }
}
