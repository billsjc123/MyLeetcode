import java.util.ArrayList;
import java.util.List;

public class Leetcode_22 {
    // »ØËİ
    private StringBuilder temp = new StringBuilder("");
    private ArrayList<String> ans = new ArrayList<String>();
    public List<String> generateParenthesis(int n) {
        helper(n, 0, 0);
        return ans;
    }

    public void helper(int n,int l,int r){
        if(l==n && r==n){
            ans.add(temp.toString());
            return;
        }

        if(l<n){
            temp.append("(");
            helper(n, l+1, r);
        }
        if(r<l){
            temp.append(")");
            helper(n, l, r+1);
        }
        temp.deleteCharAt(temp.length()-1);
    }

    // Æ´½ÓÀ¨ºÅ
    // ArrayList[] cache = new ArrayList[10];

    // public List<String> generateParenthesis(int n) {
    //     return generate(n);
    // }

    // public List<String> generate(int n){
    //     if(cache[n]!=null)return cache[n];
        
    //     ArrayList<String> ans = new ArrayList<String>();
    //     if(n==0){
    //         ans.add("");
    //     }else{
    //         for(int i=0;i<n;i++){
    //             for(String left:generate(i)){
    //                 for(String right:generate(n-1-i)){
    //                     ans.add("("+left+")"+right);
    //                 }
    //             }
    //         }
    //     }
    //     return ans;
    // }
}
