import org.junit.Test;

public class Offer2 {
    public String replaceSpace(StringBuffer str) {
        int len = str.length();
    	for (int i = 0; i < len; i++) {
            if(str.charAt(i)==' '){
                str.replace(i, i+1, "%20");
                i+=2;
                len+=2;
            }
        }
        return str.toString();
    }

    @Test
    public void test(){
        StringBuffer str = new StringBuffer(" We are the champion. ");
        System.out.println(replaceSpace(str));
    }
}