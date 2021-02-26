public class ShellSort {
    public static int[] shellSort(int[] arr) {
        int gap = arr.length >> 1;
        while (gap > 0) {
            for (int i = gap; i < arr.length; i++) {
                int preIdx = i - gap;
                int curIdx = i;
                int temp = arr[i];
                while(curIdx >= gap && arr[curIdx]<arr[preIdx]){
                    arr[curIdx]=arr[preIdx];
                    curIdx-=gap;
                    preIdx-=gap;
                }
                arr[curIdx]=temp;
            }
            gap >>= 1;
        }
        return arr;
    }
}
