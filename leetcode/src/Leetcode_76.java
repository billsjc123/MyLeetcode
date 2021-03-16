import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

public class Leetcode_76 {
    HashMap<Character, Integer> ori = new HashMap<Character, Integer>();
    HashMap<Character, Integer> cnt = new HashMap<Character, Integer>();

    public String minWindow(String s, String t) {
        int sLen = s.length();
        int l = 0, r = -1;
        int ansL = 0, ansR = -1, ansLen = Integer.MAX_VALUE;
        for (char c : t.toCharArray()) {
            ori.put(c, ori.getOrDefault(c, 0) + 1);
        }
        while (r < sLen) {
            ++r;
            if (r < sLen) {
                cnt.put(s.charAt(r), cnt.getOrDefault(s.charAt(r), 0) + 1);
            }
            while (check() && l <= r) {
                if (r - l + 1 < ansLen) {
                    ansL = l;
                    ansR = r;
                    ansLen = r - l + 1;
                }
                cnt.put(s.charAt(l), cnt.getOrDefault(s.charAt(l), 1) - 1);
                ++l;
            }
        }
        return ansR >= 0 ? s.substring(ansL, ansR + 1) : "";
    }

    public boolean check() {
        Iterator iter = ori.entrySet().iterator();
        while (iter.hasNext()) {
            Entry<Character, Integer> entry = (Entry<Character, Integer>) iter.next();
            if (cnt.getOrDefault(entry.getKey(), 0) < entry.getValue()) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Leetcode_76 l = new Leetcode_76();
        l.minWindow("ADOBECODEBANC", "ABC");
    }
}
