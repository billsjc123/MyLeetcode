import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.junit.Test;

public class Leetcode_139 {
    int minLen;
    int maxLen;

    public boolean wordBreak(String s, List<String> wordDict) {
        if (wordDict.size() == 0 || s.length() == 0)
            return false;
        Collections.sort(wordDict, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.length() != o2.length()) {
                    return o1.length() - o2.length();
                } else {
                    return o1.compareTo(o2);
                }
            }
        });

        minLen = wordDict.get(0).length();
        maxLen = wordDict.get(wordDict.size() - 1).length();
        return helper(s, wordDict, 0);
    }

    public boolean helper(String s, List<String> wordDict, int startIdx) {
        if (startIdx >= s.length())
            return true;
        if (s.length() - startIdx < minLen)
            return false;
        
        for (int i = minLen; i <= maxLen; i++) {
            for (String word : wordDict) {
                if (s.substring(startIdx, startIdx + i).equals(word)) {
                    return helper(s, wordDict, startIdx + i);
                }
            }
        }
        return false;
    }

    @Test
    public void test(){
        List<String> wordDict= Arrays.asList("leet","code");
        System.out.println(wordBreak("leetcode", wordDict));
    }
}
