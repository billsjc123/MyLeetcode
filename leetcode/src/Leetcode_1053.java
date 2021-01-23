import org.junit.Test;

public class Leetcode_1053 {
    public int[] prevPermOpt1(int[] arr) {
        int len = arr.length;
        if (len == 1)
            return arr;

        int i = len - 1;

        // 如果最后两个值是递减的，则直接交换
        if (arr[i - 1] > arr[i]) {
            swap(arr, i, i - 1);
            return arr;
        }
        // 倒序寻找非递减序列的起始位置
        for (; i >= 1 && arr[i - 1] <= arr[i]; i--)
            ;
        // 整个数组为非递减
        if (i == 0)
            return arr;

        i--;
        // 找到最左边的大于arr[i]的数并交换
        for (int j = len - 1; j > i; j--) {
            if(arr[j]==arr[j-1])
                continue;
            if (arr[j] < arr[i]) {
                swap(arr, i, j);
                return arr;
            }
        }

        return arr;
    }

    void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    @Test
    public void test1(){
        int[] arr = new int[]{1,2};
        swap(arr, 0, 1);
        System.out.println(arr[0]);
    }
}
