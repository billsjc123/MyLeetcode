import java.util.Arrays;
import java.util.Comparator;

public class Offer45 {
    public String minNumber(int[] nums) {
        String[] strNums= new String[nums.length];
        for (int i = 0; i < strNums.length; i++) {
            strNums[i]=String.valueOf(nums[i]);
        }
        Arrays.sort(strNums, new Comparator<String>(){
            @Override
            public int compare(String x, String y) {
                String s1 = x+y;
                String s2 = y+x;
                long n1 = Long.parseLong(s1);
                long n2 = Long.parseLong(s2);
                if(n1>n2)return 1;
                else if(n1<n2)return -1;
                else return 0;
            };
        });
        String ans = "";
        for(String str:strNums){
            ans+=str;
        }
        return ans;
    }
}
