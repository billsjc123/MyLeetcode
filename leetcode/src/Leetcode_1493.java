public class Leetcode_1493 {
    public int longestSubarray(int[] nums) {
        int max = -1;
        int lastZero = -1;
        int tmp = 0;
        for (int i = 0; i < nums.length; i++) {
            // �����λ��1���ض����Ժ���һλ����ʾ��������ƴ����������+1
            if (nums[i] == 1) {
                tmp += 1;
            } else {
                // �����0�������������1������������һ��0����λ���м������1
                // ��һ��0֮ǰ������1������ƴ�����ˣ���Ϊ������Ҫɾ������0
                tmp = i - lastZero - 1;
                lastZero = i;       // ������һ��0��λ��
            }
            max = Math.max(tmp, max);
        }
        // ȫΪ1�����������ҲҪɾ��һ��
        return Math.min(max, nums.length - 1);
    }
}
