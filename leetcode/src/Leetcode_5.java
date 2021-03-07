import org.junit.Test;

public class Leetcode_5 {
    private static class InstanceHolder{
        private static Leetcode_5 Instance = new Leetcode_5();
    }

    public Leetcode_5 getInstance(){
        return InstanceHolder.Instance;
    }
    public String longestPalindrome(String s) {
        int len = s.length();
        if(len==0)return "";
        int dp[] = new int[len+1];
        dp[0]=1;
        int maxIdx = 0;
        for(int i=1;i<len;i++){
            dp[i]=1;
            if(s.charAt(i)==s.charAt(i-1))dp[i]=2;
            int lastIdx = i-1-dp[i-1];
            if(lastIdx>=0 && s.charAt(i)==s.charAt(lastIdx))
            {
                dp[i]=dp[i-1]+2;
            }
            maxIdx=dp[i]>dp[maxIdx]?i:maxIdx;
        }
        return s.substring(maxIdx-dp[maxIdx]+1,maxIdx+1);
    }

    @Test
    public void test(){
        System.out.println(longestPalindrome("ababa"));
    }
}
