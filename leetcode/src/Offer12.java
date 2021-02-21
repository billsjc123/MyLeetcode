import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import org.junit.Test;

public class Offer12 {
    HashSet<List<Integer>> valid = new HashSet<List<Integer>>();
    int[][] directions = new int[][] { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };
    int rows, cols;

    public boolean exist(char[][] board, String word) {
        rows = board.length;
        cols = board[0].length;
        for (int m = 0; m < board.length; m++) {
            for (int n = 0; n < board[0].length; n++) {
                if (board[m][n] == word.charAt(0)) {
                    List<Integer> loc = Arrays.asList(m,n);
                    valid.add(loc);
                    if (dfs(board, word, m, n, 0))
                        return true;
                    valid.remove(loc);
                }
            }
        }
        return false;
    }

    public boolean dfs(char[][] board,String word,int i,int j,int idx){
        if(board[i][j]==word.charAt(idx)){
            if(idx==word.length()-1)return true;
            else{
                for (int[] direction : directions) {
                    int newi = i+direction[0],newj = j+direction[1];
                    List<Integer> loc = Arrays.asList(newi,newj);
                    if(newi<rows && newi>=0 &&newj<cols && newj>=0 && !valid.contains(loc)){
                        valid.add(loc);
                        boolean ans = dfs(board,word,newi,newj,idx+1);
                        valid.remove(loc);
                        if(ans)return true;
                    }
                }
                return false;
            }
        }
        else return false;
    }
    @Test
    public void test(){
        HashSet<List<Integer>> valid = new HashSet<List<Integer>>();
        valid.add(Arrays.asList(1,2));
        System.out.println(valid.contains(Arrays.asList(1,2)));
    }
}

