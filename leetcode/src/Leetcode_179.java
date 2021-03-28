import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;

import org.junit.Test;

public class Leetcode_179 {
    public String largestNumber(int[] nums) {
        String str[] = new String[nums.length];
        for(int i=0;i<nums.length;++i){
            str[i]=String.valueOf(nums[i]);
        }
        Arrays.sort(str,new Comparator<String>(){
            @Override
            public int compare(String s1,String s2){
                if(s1.length()==s2.length())
                    return -s1.compareTo(s2);
                int i=0;
                while(i<Math.min(s1.length(),s2.length())){
                    char c1 = s1.charAt(i);
                    char c2 = s2.charAt(i);
                    if(c1!=c2){
                        return -s1.compareTo(s2);
                    }
                }
                if(i==s1.length()){
                    return s2.charAt(i)-s1.charAt(0);
                }else{
                    return s1.charAt(i)-s2.charAt(0);
                }
            }
        });
        StringBuilder ans = new StringBuilder();
        for(String s:str){
            ans.append(s);
        }
        return ans.toString();
    }
    @Test
    public void test(){
        String[] strs = new String[] {"30","31","32","3","34"};
        Arrays.sort(strs);
        for(String str:strs){
            System.out.println(str);
        }
        
    }
}
