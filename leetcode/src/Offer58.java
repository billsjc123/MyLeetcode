import java.util.Stack;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;

public class Offer58 {
    public String reverseWords(String s) {
        int len = s.length();
        Stack<String> stack = new Stack<String>();
        for (int i = 0; i < len; i++) {
            if (s.charAt(i) == ' ') {
                continue;
            }
            int j = i;
            while (j < len && s.charAt(j) != ' ') {
                j++;
            }
            stack.push(s.substring(i, j));
        }
        Future future;
        ThreadPoolExecutor threadPoolExecutor;
        Executors executor;

        StringBuilder ans = new StringBuilder(stack.pop());
        while (!stack.isEmpty()) {
            ans.append(" " + stack.pop());
        }
        return ans.toString();
    }
}
