import java.util.Stack;

public class Offer31 {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        int pushIdx = 0,popIdx =0;
        Stack<Integer> s = new Stack<Integer>();
        while(popIdx<popped.length){
            // push直到栈顶等于当前第一个被pop的数字
            while((s.isEmpty()||s.peek()!=popped[popIdx])&&pushIdx<pushed.length){
                s.push(pushed[pushIdx++]);
            }
            if(s.peek()==popped[popIdx]){
                s.pop();
                popIdx++;
            }else{ 
                break;          // pushed已经全部push了
            }
        }
        return s.isEmpty();
    }
}
