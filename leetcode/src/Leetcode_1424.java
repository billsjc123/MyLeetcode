import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;


public class Leetcode_1424 {
    public int[] findDiagonalOrder(List<List<Integer>> nums) {
        int m = nums.size();

        int total = 0;

        TreeMap<Integer, List<Integer>> map = new TreeMap<Integer, List<Integer>>();
        for (int i = 0; i < m; i++) {
            int n = nums.get(i).size();
            total += n;
            for (int j = 0; j < n; j++) {
                if (map.containsKey(i + j)) {
                    map.get(i + j).add(nums.get(i).get(j));
                } else {
                    List<Integer> l = new ArrayList<Integer>();
                    l.add(nums.get(i).get(j));
                    map.put(i + j, l);
                }
            }
        }

        int[] ans = new int[total];
        int idx = 0;
        for (int i : map.keySet()) {
            List<Integer> l = map.get(i
            );
            for (int j = l.size()-1; j >=0; j--) {
                ans[idx++] = l.get(j);
            }
        }

        return ans;
    }

}
