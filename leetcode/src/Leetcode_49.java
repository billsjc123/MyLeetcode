import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Leetcode_49 {
    ArrayList<List<String>> ans = new ArrayList<List<String>>();
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<String>>map = new HashMap<String,List<String>>();
        for(String str:strs){
            int[] alphabet = new int[26];
            for(char c:str.toCharArray()){
                alphabet[c-'a']++;
            }
            StringBuilder stringBuilder = new StringBuilder();
            for(int i=0;i<26;i++){
                for(int k=0;k<alphabet[i+'a'];k++){
                    stringBuilder.append((char)i+'a');
                }
            }
            String orderedStr = stringBuilder.toString();
            List<String> list = map.getOrDefault(orderedStr,new ArrayList<String>());
            list.add(str);
        }
        for(List<String> list:map.values()){
            ans.add(list);
        }
        return ans;
    }
}
