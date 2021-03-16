import java.io.BufferedInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Leetcode_78 {
    // µü´ú
    // public List<List<Integer>> subsets(int[] nums) {
    // ArrayList<List<Integer>> ans = new ArrayList<List<Integer>>();
    // for(int i=0;i<Math.pow(2,nums.length);i++){
    // int x = i;
    // ArrayList<Integer> temp = new ArrayList<Integer>();
    // int idx = 0;
    // while(x>0){
    // int bit = x%2;
    // if(bit==1){
    // temp.add(nums[idx]);
    // }
    // x >>= 1;
    // ++idx;
    // }
    // ans.add(temp);
    // }
    // return ans;
    // }
    ArrayList<List<Integer>> ans = new ArrayList<List<Integer>>();
    ArrayList<Integer> temp = new ArrayList<Integer>();

    // µÝ¹é
    public List<List<Integer>> subsets(int[] nums) {
        dfs(nums, 0);
        return ans;
    }

    public void dfs(int[] nums, int cur) {
        if (cur == nums.length) {
            ans.add(temp);
            return;
        }

        temp.add(nums[cur]);
        dfs(nums, cur + 1);
        temp.remove(temp.size() - 1);
        dfs(nums, cur + 1);
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(new BufferedInputStream(System.in));
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            double d = sc.nextDouble();
            System.out.println(d);
        }
    }
}
