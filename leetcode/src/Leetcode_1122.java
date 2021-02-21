public class Leetcode_1122 {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] freq = new int[1001];
        for (int i : arr1) {
            freq[i]++;
        }

        int idx = 0;
        for (int i : arr2) {
            for (int j = 0; j < freq[i]; j++) {
                arr1[idx] = i;
                idx++;
            }
            freq[i]=0;
        }

        for (int i = 0; i < freq.length; i++) {
            if(freq[i]>0){
                for (int j = 0; j < freq[i]; j++) {
                    arr1[idx] = i;
                    idx++;
                }
            }
        }

        return arr1;
    }
}
