import org.junit.Test;

public class Leetcode_10 {
    public boolean isMatch(String s, String p) {
        boolean[][] dp=new boolean[s.length()+1][p.length()+1];
        dp[0][0]=true;
        for(int j=1;j<=p.length() && p.charAt(j-1)=='*';j++){
            dp[0][j]=true;
        }
        for(int i=1;i<=s.length();i++){
            for(int j=1;j<=p.length();j++){
                if(isCharacter(p.charAt(j-1))){
                    dp[i][j]=dp[i-1][j-1] && s.charAt(i-1)==p.charAt(j-1);
                }else if(p.charAt(j-1)=='.'){
                    dp[i][j]=dp[i-1][j-1];
                }else{
                    //一个都不匹配
                    dp[i][j]=dp[i][j-2];
                    //匹配一个或以上
                    if(s.charAt(i-1)==p.charAt(j-2))
                        dp[i][j]=dp[i][j] || dp[i-1][j];
                }
            }
        }
        return dp[s.length()][p.length()];
    }

    public boolean isCharacter(char c){
        if(c>='a' && c<='z')return true;
        return false;
    }

    @Test
    public void test(){
        System.out.println(isMatch("aab", "*a*b"));
    }
}
