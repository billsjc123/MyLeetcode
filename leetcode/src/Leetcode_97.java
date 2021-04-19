import org.junit.Test;

class Leetcode_97 {
    public boolean isInterleave(String s1, String s2, String s3) {
        if(s1.length()==0)return s2.equals(s3);
        else if(s2.length()==0)return s1.equals(s3);
        return dfs(s1,s2,s3,0,0,0);
    }

    public boolean dfs(String s1,String s2,String s3,int id1,int id2,int id3){
        if(id3==s3.length() && id1==s1.length() && id2==s2.length())return true;
        else if(id1==s1.length())return s2.substring(id2,s2.length()).equals(s3.substring(id3,s3.length()));
        else if(id2==s2.length())return s1.substring(id1,s1.length()).equals(s3.substring(id3,s3.length()));

        if(s1.charAt(id1)==s3.charAt(id3)){
            if(dfs(s1,s2,s3,id1+1,id2,id3+1))
                return true;
        }


        if(s2.charAt(id2)==s3.charAt(id3)){
            if(dfs(s1,s2,s3,id1,id2+1,id3+1))
                return true;
        }

        return false;
    }

    public static void main(String[] args) {
        Leetcode_97 lc = new Leetcode_97();
        System.out.println(lc.isInterleave("a", "", "a"));
        
    }
}