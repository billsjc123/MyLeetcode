public class Leetcode_1535 {
    public int getWinner(int[] arr, int k) {
        int len = arr.length;
        int i =1;
        int curWinner=arr[0];
        int winCnt=0;
        while(i<len){
            if(arr[i]<curWinner){
                winCnt++;
                if(winCnt==k)return curWinner;
            }
            else{
                curWinner=arr[i];
                winCnt=1;
            }
            i++;
        }
    }
}
