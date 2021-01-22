import org.junit.Test;

public class Leetcode_79 {
    int m, n;

    public boolean exist(char[][] board, String word) {
        m = board.length;
        n = board[0].length;
        boolean visited[][] = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (word.charAt(0) == board[i][j]) {
                    if (dfs(board, i, j, word, 0, visited))
                        return true;
                }
            }
        }
        return false;
    }

    boolean dfs(char[][] board, int i, int j, String word, int idx, boolean visited[][]) {

        if (i < 0 || j < 0 || i >= m || j >= m)
            return false;
        if (visited[i][j])
            return false;
        if (board[i][j] == word.charAt(idx)) {
            if (idx == word.length() - 1)
                return true;
            visited[i][j] = true;

            int[][] offset = {{0,1},{0,-1},{1,0},{-1,0}};

            for (int k = 0; k < 4; k++) {
                if(dfs(board, i+offset[k][0], j+offset[k][1], word, idx+1, visited)){
                    visited[i][j]=false;
                    return true;
                }
            }
            visited[i][j] = false;
            return false;
        }
        return false;
    }
    
    @Test
    public void test1(){
        char[][] t = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        String word = "SEE";
        exist(t, word);
    }
}
