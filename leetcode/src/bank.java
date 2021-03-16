import org.junit.Test;

public class bank {
    // 3�����������дһ�����򽫰��������ֵĽ��תΪ���Ĵ�д�������������С����ǰʮλ��С�������λ����
    // ����: 123456789.123
    // ���: Ҽ�ڷ�Ǫ������ʰ����½Ǫ��۰�ʰ��ԲҼ�Ƿ�������

    char[] alphabet = new char[] { '��', 'Ҽ', '��', '��', '��', '��', '½', '��', '��', '��' };
    char[] chinese = new char[] { 'ʰ', '��', 'Ǫ' };

    public String bank(double num) {
        int x = (int) num;
        return parseInt(x) + parseFloat(num - x);
    }

    public String parseInt(int num) {
        return parseInt2(num, 0).reverse().toString();
    }

    // k=0�����λ��1������2������
    public StringBuilder parseInt2(int num, int k) {
        if (num == 0)
            return new StringBuilder("");
        int temp = num;
        StringBuilder str = new StringBuilder();
        int cnter = -1;

        // �޸�1��
        // ���ڻ������ʱ��Ҫ���ֵ�һ����0λ�����'��'or'��'����Ȼ�����100000001 => һ�� �� һ

        // �޸�2��0�Ĵ������
        // ���������0��
        // 1.�������С��λ���ֹ���0������Ҫ���һ����
        // 2.���λ��0����������һ��0������֮ǰ��û�г��ֹ���0
        // 3.���λ
        // 4.���ԣ�
        // 1���������˷�0��������nonZeroFlagΪtrue
        // 2��������0����nonZeroFlagΪtrue˵������С��λ�з�0�������Ҫ����㣬zeroFlag��Ϊtrue�����û�������������������
        // 3�������˷�0����zeroFlagΪtrue����˵������С��λ��0�������

        // �޸�3��
        // �����˵ݹ�ķ����������ظ��Ĵ����߼�����Ϊ�����λ����λ����λ��˼·����һ�µģ������Ӳ���k�������Ƕ��ڻ�����Ĵ���

        // ��ʾ��λ���ֹ���0��
        boolean nonZeroFlag = false;
        // ��ʾ��λ���ֹ�0�������0�������λ
        boolean zeroFlag = false;
        // ��λ
        while (temp > 0 && cnter < 3) {
            int x = temp % 10;
            // ��Ϊ0�����
            if (x != 0) {
                if (!nonZeroFlag) {
                    if (k == 1)
                        str.append('��');
                    else if (k == 2)
                        str.append('��');
                }
                nonZeroFlag = true;
                // 0�������λ�������
                if (zeroFlag) {
                    str.append('��');
                    // ���һ�ξͺ�
                    zeroFlag = false;
                }
                if (cnter >= 0) {
                    str.append(chinese[cnter]);
                }
                str.append(alphabet[x]);
            } else {
                // Ϊ0��ǰ����ֹ�0������Ҫ�����
                zeroFlag = nonZeroFlag;
                // ���λ��0���������Ҫ���һ����
                if (nonZeroFlag && cnter == 2) {
                    str.append('��');
                }
            }
            temp = temp / 10;
            cnter++;
        }
        if (temp > 0) {
            str.append(parseInt2(temp, k + 1));
        }
        return str;

        // // ��λ
        // nonZeroFlag = false;
        // zeroFlag = false;
        // cnter = -1;
        // if (temp > 0){
        // while (temp > 0 && cnter<3) {
        // int x = temp % 10;
        // // ��Ϊ0�����
        // if (x != 0) {
        // // ��һ�γ��ַ�0��λ���ȼ�һ����
        // if(!nonZeroFlag)
        // str.append('��');
        // nonZeroFlag = true;

        // // 0�������λ�������
        // if(zeroFlag){
        // str.append('��');
        // // ���һ�ξͺ�
        // zeroFlag=false;
        // }
        // if (cnter >= 0) {
        // str.append(chinese[cnter]);

        // }
        // str.append(alphabet[x]);
        // }else{
        // // Ϊ0��ǰ����ֹ�0������Ҫ�����
        // zeroFlag = nonZeroFlag;
        // if(nonZeroFlag && cnter==2){
        // str.append('��');
        // }
        // }
        // temp = temp / 10;
        // cnter++;
        // }
        // }
        // // ��λ
        // nonZeroFlag = false;
        // zeroFlag = false;
        // cnter = -1;
        // if (temp > 0){
        // while (temp > 0 && cnter<3) {
        // int x = temp % 10;
        // // ��Ϊ0�����
        // if (x != 0) {
        // // ��һ�γ��ַ�0��λ���ȼ�һ����
        // if(!nonZeroFlag)
        // str.append('��');
        // nonZeroFlag = true;
        // // 0�������λ�������
        // if(zeroFlag){
        // str.append('��');
        // // ���һ�ξͺ�
        // zeroFlag=false;
        // }
        // if (cnter >= 0) {
        // str.append(chinese[cnter]);
        // }
        // str.append(alphabet[x]);
        // }else{
        // // Ϊ0��ǰ����ֹ�0������Ҫ�����
        // zeroFlag = nonZeroFlag;
        // if(nonZeroFlag && cnter==2){
        // str.append('��');
        // }
        // }
        // temp = temp / 10;
        // cnter++;
        // }
        // }
        // return str.reverse().toString();
    }

    // С�����ֲ��ô���0�����
    public String parseFloat(double num) {
        StringBuilder str = new StringBuilder();
        int temp = (int) Math.round(num * 100);
        if (num * 1000 - (int) (num * 1000) >= 0.5) {
            temp = (int) (num * 1000) + 1;
        } else {
            temp = (int) (num * 1000);
        }

        char[] n2c = new char[] { '��', '��', '��' };
        int cnter = 2;
        while (temp > 0) {
            int x = temp % 10;
            if (x != 0) {
                str.append(n2c[cnter]);
                str.append(alphabet[x]);
            }
            temp = temp / 10;
            cnter--;
        }
        return str.reverse().toString();
    }

    @Test
    public void test() {
        System.out.println(bank(1010101010.123));
    }
}
