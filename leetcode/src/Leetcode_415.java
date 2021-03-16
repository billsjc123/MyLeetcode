public class Leetcode_415 {
    public String addStrings(String num1, String num2) {
        if (num1.length() < num2.length())
            return addStrings(num2, num1);
        if (num2.length() == 0)
            return num1;
        int carry = 0;
        StringBuffer ans = new StringBuffer(num1);
        for (int i = 0; i < num1.length(); i++) {
            int x = i < num2.length() ? num2.charAt(num2.length() - 1 - i) - '0' : 0;
            int y = num1.charAt(num1.length() - 1 - i) - '0';
            int sum = x + y + carry;
            carry = sum >= 10 ? 1 : 0;
            ans.setCharAt(num1.length() - 1 - i, (char) (sum % 10 + '0'));
        }

        if (carry == 1) {
            ans = new StringBuffer("1").append(ans);
        }
        return ans.toString();
    }
}
