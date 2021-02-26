import org.junit.Test;
import java.util.LinkedHashMap;

public class Offer48 {
    public int lengthOfLongestSubstring(String s) {
        if(s==null)return 0;
        int alphabet[] = new int[200];
        LinkedHashMap<Character,Integer> lhm = new LinkedHashMap<Character,Integer>();
        int ans=0;
        for(int i = 0;i<alphabet.length;i++){
            alphabet[i]=-1;
        }

        int startIdx=0,curIdx=0;
        while(curIdx<s.length()){
            char c = s.charAt(curIdx);
            int cIdx = c;
            if(alphabet[cIdx]>=0){
                ans=Math.max(ans,curIdx-startIdx);
                while(startIdx<=alphabet[cIdx]){
                    alphabet[s.charAt(startIdx)]=-1;
                    startIdx++;
                }
            }
            alphabet[cIdx]=curIdx;
            curIdx++;
        }
        return ans;
    }

    @Test
    public void test(){
        System.out.println(lengthOfLongestSubstring(" "));
    }
}
