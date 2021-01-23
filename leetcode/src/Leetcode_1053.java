import org.junit.Test;

public class Leetcode_1053 {
    public int[] prevPermOpt1(int[] arr) {
        int len = arr.length;
        if (len == 1)
            return arr;

        int i = len - 1;

        // ����������ֵ�ǵݼ��ģ���ֱ�ӽ���
        if (arr[i - 1] > arr[i]) {
            swap(arr, i, i - 1);
            return arr;
        }
        // ����Ѱ�ҷǵݼ����е���ʼλ��
        for (; i >= 1 && arr[i - 1] <= arr[i]; i--)
            ;
        // ��������Ϊ�ǵݼ�
        if (i == 0)
            return arr;

        i--;
        // �ҵ�����ߵĴ���arr[i]����������
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
