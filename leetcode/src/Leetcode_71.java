import java.util.Stack;

import org.junit.Test;

public class Leetcode_71 {
    public String simplifyPath(String path) {
        Stack<String> s = new Stack<String>();
        int idx = 1;
        while(idx<path.length()){
            int nextIdx=path.indexOf("/", idx);
            nextIdx = (nextIdx==-1?path.length():nextIdx);
            String dir = path.substring(idx, nextIdx);
            if(dir.equals("..")){
                if(!s.isEmpty())
                    s.pop();
            }else if(dir.equals(".")){
            }else{
                s.push(dir);
            }
            idx = nextIdx;
            while(idx<path.length() && path.charAt(idx)=='/')idx++;
        }
        StringBuilder ans = new StringBuilder();
        if(s.isEmpty())return "/";
        while(!s.isEmpty()){
            ans.insert(0, "/"+s.pop());
        }
        return ans.toString();
    }
    @Test
    public void test(){
        System.out.println(simplifyPath("/../"));
    }
}
