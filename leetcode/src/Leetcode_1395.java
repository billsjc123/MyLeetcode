import java.util.Arrays;

public class Leetcode_1395 {
    int[] c;
    int[] iless;
    int[] imore;
    int[] kless;
    int[] kmore;
    int MAX_N;

    int lowBit(int x) {
        return x & -x;
    }

    // �����״���鷶ΧΪi��ǰ׺��
    int get(int i) {
        int ans = 0;
        while (i > 0) {
            ans += c[i];
            i -= lowBit(i);
        }
        return ans;
    }

    // ����״����iλ�ü���v
    void add(int i, int v) {
        while (i < MAX_N) {
            c[i] += v;
            i += lowBit(i);
        }
    }

    // �ҵ�ordered�е�һ������target��ֵ�±�
    int get_pos(int[] ordered,int target){
        int l = 0,r = ordered.length-1;
        while(l<r){
            int m = (l+r)>>1;

        }
    }

    public int numTeams(int[] rating) {
        int len = rating.length;
        int ans = 0;
        MAX_N = len + 2;
        c = new int[MAX_N];

        iless = new int[MAX_N];
        imore = new int[MAX_N];
        kless = new int[MAX_N];
        kmore = new int[MAX_N];
        int[] ordered_rating = rating.clone();

        // Arrays.sort(ordered_rating);

        for (int i = 0; i < len; i++) {
            int x = rating[i];
            iless[i] = get(x-1);
            imore[i] = get()
        }
        return ans;
    }
}
