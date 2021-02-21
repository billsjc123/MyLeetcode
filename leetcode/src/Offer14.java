public class Offer14 {
    public int cuttingRope(int n) {
        int ans = 1;
        for(int m = 2;m<n;m++){
            int cur_m = m;
            float cur_n=(float)n;
            int temp_ans = 1;
            while(cur_m>=1){
                int seg = (int) Math.ceil(cur_n/cur_m);
                temp_ans*=seg;
                cur_n-=seg;
                cur_m--;
            }
            if(ans>temp_ans)return ans;
            else ans=temp_ans;
        }
        return ans;
    }
}
