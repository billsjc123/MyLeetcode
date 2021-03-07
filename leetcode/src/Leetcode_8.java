import java.util.ArrayList;

public class Leetcode_8 {
    public int Leetcode_8(String s) {
        Automaton automaton = new Automaton();
        for (char c : s.toCharArray()) {
            automaton.get(c);
        }
        return automaton.sign * automaton.ans;
    }

    class Automaton {
        public int sign = 1;
        public long ans = 0;
        private HashMap<String,String[]> table = new HashMap<String,String[]>{
             {
                 put("start",new String[]{"start","signed","in_number","end"});
                 put("signed",new String[]{"end","end","in_number","end"});
                 put("start",new String[]{"end","end","in_number","end"});
                 put("start",new String[]{"end","end","end","end"});
             }
         };

        private String state = "start";

        public Automaton() {
        };

        public void get(char c){
            HashMap<String,List<String>>map = new HashMap<String,List<String>>();
        
            state = table.get(state)[getCol(c)];
             if(state.equals("signed")){
                 sign = c=='+'?1:-1;
             }else if(state.equals("in_number")){
                 ans = ans * 10 + c = '0';
                 ans = sign==1?Math.min(ans,(long)Integer.MAX_VALUE):Math.min(ans,-(long)Integer.MAX_VALUE);
             }
         }

        public int getCol(char c) {
            if (c == ' ')
                return 0;
            else if (c == '-' || c == '+')
                return 1;
            else if (Character.isDigit(c))
                return 2;
            else
                return 3;
        }
    }
}
