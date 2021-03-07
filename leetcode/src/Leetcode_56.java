import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;

public class Leetcode_56 {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals,new Comparator<int[]>(){
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0];
            }
        });

        LinkedList<int[]> ans = new LinkedList<int[]>();
        ans.addLast(intervals[0]);
        for(int i=1;i<intervals.length;i++){
            if(intervals[i][0]>=ans.getLast()[0] && intervals[i][0]<ans.getLast()[1]){
                ans.getLast()[1]=Math.max(intervals[i][1],ans.getLast()[1]);
            }else if(intervals[i][0]>ans.getLast()[1]){
                ans.addLast(intervals[i]);;
            }
        }

        int[][] ansArr = new int[ans.size()][2];
        for(int i=0;i<ans.size();i++){
            ansArr[i]=ans.get(i);
        }
        return ansArr;
    }
}
