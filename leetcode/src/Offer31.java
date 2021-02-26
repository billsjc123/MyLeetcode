import java.util.Stack;

public class Offer31 {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        int pushIdx = 0,popIdx =0;
        Stack<Integer> s = new Stack<Integer>();
        while(popIdx<popped.length){
            // pushֱ��ջ�����ڵ�ǰ��һ����pop������
            while((s.isEmpty()||s.peek()!=popped[popIdx])&&pushIdx<pushed.length){
                s.push(pushed[pushIdx++]);
            }
            if(s.peek()==popped[popIdx]){
                s.pop();
                popIdx++;
            }else{ 
                break;          // pushed�Ѿ�ȫ��push��
            }
        }
        return s.isEmpty();
    }
}
