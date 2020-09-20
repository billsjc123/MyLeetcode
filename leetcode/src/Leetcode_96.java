import org.junit.Test;

public class Leetcode_96 {
    public int numTrees(int n) {
        int []arr = new int[n+1];
        arr[1]=1;arr[0]=1;
        for (int j = 2; j <= n ; j++) {
            for (int i = 1; i <= j; i++) {
                int left = i-1,right = j-i;
                arr[j]+=arr[left]*arr[right];
            }
        }
        return arr[n];
    }
    @Test
    public void test()
    {
        System.out.println(numTrees(4));
    }
}
