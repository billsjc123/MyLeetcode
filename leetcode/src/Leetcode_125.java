public class Leetcode_125 {
    public boolean isPalindrome(String s) {
        if(s.length()==0)return true;
        s = extract(s);
        int l=0,r=s.length()-1;
        while(l<r){
            if(s.charAt(l)!=s.charAt(r))return false;
            l++;
            r--;
        }
        return true;
    }

    static String extract(String s){
        StringBuilder str = new StringBuilder();
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(c>='a' && c<='z')
                str.append(c);
            else if(c>='A' && c<='Z')
                str.append((char)(c-'A'+'a'));
        }
        return str.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Leetcode_125().isPalindrome("A man, a plan, a canal: Panama"));
    }
}
