import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class Leetcode_969 {
    public List<Integer> pancakeSort(int[] arr) {
        List<Integer> ans = new ArrayList<Integer>();
        int k = arr.length-1;
        while (k > 0) {
            for (int i = 0; i < k ; i++) {
                if (arr[i] == k+1) {
                    if (i != 0) {
                        ans.add(i+1);
                        ans.add(k+1);
                        arr = reverse(reverse(arr, i), k);
                    } else {
                        ans.add(k+1);
                        arr = reverse(arr, k);
                    }
                    break;
                }
            }
            k--;
        }
        return ans;
    }

    public int[] reverse(int[] arr, int i) {
        int start = 0, end = i;
        while (start < end) {
            int tmp = arr[start];
            arr[start] = arr[end];
            arr[end] = tmp;
            start++;
            end--;
        }
        return arr;
    }

    @Test
    public void test1(){
        int [] test = new int[]{3,4,2,3,2};
        int [] arr = new int[]{3,2,4,1};

        for (int i : test) {
            arr = reverse(arr, i);
        }

        for (int i : arr) {
            System.out.println(i);
        }
    }
}
