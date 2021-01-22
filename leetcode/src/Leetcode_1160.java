import org.junit.Test;

public class Leetcode_1160 {
    public int countCharacters(String[] words, String chars) {
        int[] alphabet = new int[26];
        int ans = 0;
        for (int i = 0; i < chars.length(); i++) {
            char c = chars.charAt(i);
            alphabet[c - 'a']++;
        }

        for (String word : words) {
            int[] temp = new int[26];
            boolean know = true;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                temp[c - 'a']++;
            }
            for (int i = 0; i < alphabet.length; i++) {
                if (alphabet[i] < temp[i]) {
                    know = false;
                    break;
                }
            }
            ans += know ? word.length() : 0;
        }
        return ans;
    }

    @Test
    public void test(){
        System.out.println(countCharacters(new String[]{"cat","bt","hat","tree"}, "atach"));
    }
}
