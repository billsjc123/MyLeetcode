import org.junit.Test;

public class bank {
    // 3、请帮助银行写一个程序将阿拉伯数字的金额转为中文大写。输入数字最多小数点前十位，小数点后三位数。
    // 输入: 123456789.123
    // 输出: 壹亿贰仟叁佰肆拾伍万陆仟柒佰捌拾玖圆壹角贰分叁厘

    char[] alphabet = new char[] { '零', '壹', '贰', '叁', '肆', '伍', '陆', '柒', '捌', '玖' };
    char[] chinese = new char[] { '拾', '佰', '仟' };

    public String bank(double num) {
        int x = (int) num;
        return parseInt(x) + parseFloat(num - x);
    }

    public String parseInt(int num) {
        return parseInt2(num, 0).reverse().toString();
    }

    // k=0代表个位，1代表万，2代表亿
    public StringBuilder parseInt2(int num, int k) {
        if (num == 0)
            return new StringBuilder("");
        int temp = num;
        StringBuilder str = new StringBuilder();
        int cnter = -1;

        // 修改1：
        // 在亿或者万的时候，要出现第一个非0位才输出'亿'or'万'，不然会出现100000001 => 一亿 万 一

        // 修改2：0的处理策略
        // 如果遇到了0：
        // 1.如果比他小的位出现过非0，则需要输出一个零
        // 2.最高位是0，则必须输出一个0，无论之前有没有出现过非0
        // 3.最高位
        // 4.策略：
        // 1）当遇到了非0，首先置nonZeroFlag为true
        // 2）遇到了0，若nonZeroFlag为true说明比他小的位有非0，则可能要输出零，zeroFlag设为true，如果没有遇到，不可能输出零
        // 3）遇到了非0，若zeroFlag为true，则说明比他小的位有0，输出零

        // 修改3：
        // 采用了递归的方法，减少重复的处理逻辑，因为处理个位，万位，亿位的思路都是一致的，新增加参数k代表这是对亿或者万的处理

        // 表示低位出现过非0了
        boolean nonZeroFlag = false;
        // 表示低位出现过0了且这个0不是最低位
        boolean zeroFlag = false;
        // 个位
        while (temp > 0 && cnter < 3) {
            int x = temp % 10;
            // 不为0的情况
            if (x != 0) {
                if (!nonZeroFlag) {
                    if (k == 1)
                        str.append('万');
                    else if (k == 2)
                        str.append('亿');
                }
                nonZeroFlag = true;
                // 0不是最高位，输出零
                if (zeroFlag) {
                    str.append('零');
                    // 输出一次就好
                    zeroFlag = false;
                }
                if (cnter >= 0) {
                    str.append(chinese[cnter]);
                }
                str.append(alphabet[x]);
            } else {
                // 为0且前面出现过0，可能要输出零
                zeroFlag = nonZeroFlag;
                // 最高位非0的情况，需要输出一个零
                if (nonZeroFlag && cnter == 2) {
                    str.append('零');
                }
            }
            temp = temp / 10;
            cnter++;
        }
        if (temp > 0) {
            str.append(parseInt2(temp, k + 1));
        }
        return str;

        // // 万位
        // nonZeroFlag = false;
        // zeroFlag = false;
        // cnter = -1;
        // if (temp > 0){
        // while (temp > 0 && cnter<3) {
        // int x = temp % 10;
        // // 不为0的情况
        // if (x != 0) {
        // // 第一次出现非0的位，先加一个万
        // if(!nonZeroFlag)
        // str.append('万');
        // nonZeroFlag = true;

        // // 0不是最高位，输出零
        // if(zeroFlag){
        // str.append('零');
        // // 输出一次就好
        // zeroFlag=false;
        // }
        // if (cnter >= 0) {
        // str.append(chinese[cnter]);

        // }
        // str.append(alphabet[x]);
        // }else{
        // // 为0且前面出现过0，可能要输出零
        // zeroFlag = nonZeroFlag;
        // if(nonZeroFlag && cnter==2){
        // str.append('零');
        // }
        // }
        // temp = temp / 10;
        // cnter++;
        // }
        // }
        // // 亿位
        // nonZeroFlag = false;
        // zeroFlag = false;
        // cnter = -1;
        // if (temp > 0){
        // while (temp > 0 && cnter<3) {
        // int x = temp % 10;
        // // 不为0的情况
        // if (x != 0) {
        // // 第一次出现非0的位，先加一个亿
        // if(!nonZeroFlag)
        // str.append('亿');
        // nonZeroFlag = true;
        // // 0不是最高位，输出零
        // if(zeroFlag){
        // str.append('零');
        // // 输出一次就好
        // zeroFlag=false;
        // }
        // if (cnter >= 0) {
        // str.append(chinese[cnter]);
        // }
        // str.append(alphabet[x]);
        // }else{
        // // 为0且前面出现过0，可能要输出零
        // zeroFlag = nonZeroFlag;
        // if(nonZeroFlag && cnter==2){
        // str.append('零');
        // }
        // }
        // temp = temp / 10;
        // cnter++;
        // }
        // }
        // return str.reverse().toString();
    }

    // 小数部分不用处理0的情况
    public String parseFloat(double num) {
        StringBuilder str = new StringBuilder();
        int temp = (int) Math.round(num * 100);
        if (num * 1000 - (int) (num * 1000) >= 0.5) {
            temp = (int) (num * 1000) + 1;
        } else {
            temp = (int) (num * 1000);
        }

        char[] n2c = new char[] { '角', '分', '厘' };
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
