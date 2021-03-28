import org.junit.Test;

public class QuickSort {
    // 已知数列: [6 1 2 7 9 3 4 5 10 8], 请用快速排序, 将该数列从小到大排好, 并输出中间每一轮的排序结果
    public void QuickSort(int[] arr, int l, int r, int count) {
        if (l >= r)
            return;
        System.out.println("第"+(count-1)+"次快速排序:");
        for(int num:arr){
            System.out.print(num+" ");
        }
        System.out.println("");
        int p = partition(arr, l, r);
        QuickSort(arr, l, p - 1, count + 1);
        QuickSort(arr, p + 1, r, count + 1);
    }

    // public int partition(int[] arr, int start, int end) {
    //     int pivot = arr[start];
    //     int l = start+1, r = end;
    //     while (l < r) {
    //         while (l < r && arr[l] < pivot)
    //             l++;
    //         while (l < r && arr[r] > pivot)
    //             r--;
    //         if (l < r)
    //             swap(arr, l, r);
    //     }
    //     arr[r]=pivot;
    //     return r;
    // }

    public int partition(int[] arr, int start, int end) {
        int pivot = arr[start];
        int l = start, r = end + 1;
        while (true) {
            while (l < end && arr[++l] < pivot)
                ;
            while (r > start && arr[--r] > pivot)
                ;
            if (l >= r)
                break;
            swap(arr, l, r);
        }
        swap(arr, start, r);
        return r;
    }

    public void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    @Test
    public void test() {
        // int[] arr = new int[] { 5, 7, 2, 3, 5, 1, 4,13,52,21,31,5,151,63 };
        int[] arr = new int[] { 9,8,7,6,5,4,4,3,2,1 };
        QuickSort(arr, 0, arr.length - 1, 1);
        System.out.println("最终结果：");
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}
