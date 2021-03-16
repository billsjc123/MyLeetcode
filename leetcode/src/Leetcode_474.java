public class Leetcode_474 {
    public int findMaxForm(String[] strs, int m, int n) {
        int[][] dp = new int[m+1][n+1];
        for(String str:strs){
            int ones = getOneCount(str),zeros = str.length()-ones;
            for(int i=zeros;i<=m;i++){
                for(int j=ones;j<=n;j++){
                    dp[i][j]=Math.max(dp[i-zeros][j-ones]+1,dp[i][j]);
                }
            }
        }
        return dp[m][n];
    }

    public int getOneCount(String str){
        int count = 0;
        for(char c:str.toCharArray()){
            if(c=='1')count++;
        }
        return count;
    }
}
