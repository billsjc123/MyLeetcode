public class Offer40 {
    
    // ¶ÑÅÅĞò
    public int[] getLeastNumbers(int[] arr, int k) {
        int len = arr.length;
        int[] ans=new int[k];
        // ¹¹½¨Ğ¡¶¥¶Ñ
        for(int i = (len+1)/2 -1;i>=0;i--){
            heapify(arr,i,len);
        }
        for(int i = 0;i<k;i++){
            ans[i]=arr[0];
            swap(arr,len-1-i,0);
            heapify(arr,0,len-1-i);
        }
        return ans;
    }

    // Ğ¡¶¥¶Ñ
    public void heapify(int[] arr,int k,int len){
        for(int i = 2*k+1;i<len;i=2*i+1){
            if(i+1<len && arr[i]>arr[i+1])i++;
            if(arr[k]>arr[i])
                swap(arr,k,i);
            k = i;
        }
    }

    public void swap(int[] arr,int i,int j){
        int temp = arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
}
