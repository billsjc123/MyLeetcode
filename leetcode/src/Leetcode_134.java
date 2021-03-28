public class Leetcode_134 {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int idx = 0;
        while(idx<n){
            int curGas = 0;
            int cnt = 0;
            while(cnt<n){
                int j = (idx+cnt)%n;
                curGas+=gas[j]-cost[j];
                if(curGas<0)break;
                cnt++;
            }
            if(cnt==n){
                return idx;
            }else{
                idx += cnt+1;
            }
        }
        return -1;
    }
}
