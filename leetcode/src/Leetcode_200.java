import java.util.LinkedList;
import java.util.Queue;

public class Leetcode_200 {
    // ���鼯
    class UnionFind {
        private int[] parent;
        private int[] rank;
        private int count;

        UnionFind(char[][] grid) {
            int m = grid.length;
            int n = grid[0].length;
            parent = new int[m * n];
            rank = new int[m * n];
            count = 0;

            // ���鼯��ʼ��
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == '1') {
                        parent[i * n + j] = i * n + j;
                        count++;
                    }
                    rank[i * n + j] = 0;
                }
            }
        }

        // ����˭��x�ĸ��ڵ�
        public int find(int x) {
            return parent[x] == x ? parent[x] : find(parent[x]);
        }

        // �ϲ�������
        public void union(int i, int j) {
            int x = find(i), y = find(j);
            if (rank[x] < rank[y]) {
                parent[x] = y;
            } else if (rank[x] > rank[y]) {
                parent[y] = x;
            }

            if (x != y && rank[x] == rank[y]) {
                parent[x] = y;
                rank[y]++;
            }
            count--;
        }

        public int getCount() {
            return count;
        }
    }

    public int numIslands(char[][] grid) {
        UnionFind unionFind = new UnionFind(grid);
        int m = grid.length;
        int n = grid[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    // ��
                    if(i>0 && unionFind.find(i * n + j)!=unionFind.find((i-1)*n+j))
                        unionFind.union(i * n + j, (i-1)*n+j);
                    // ��
                    if(j>0 && unionFind.find(i * n + j)!=unionFind.find(i * n + j-1))
                        unionFind.union(i * n + j,i * n + j-1);
                    // ��
                    if(i<m-1 && unionFind.find(i * n + j)!=unionFind.find((i+1) * n + j))
                        unionFind.union(i * n + j,(i+1) * n + j);
                    // ��
                    if(j<n-1 && unionFind.find(i * n + j)!=unionFind.find(i * n + j+1))
                        unionFind.union(i * n + j,i * n + j+1);
                }
            }
        }
        return unionFind.getCount();
    }

    // dfs
    // public int numIslands(char[][] grid) {
    // int m = grid.length;
    // int n = grid[0].length;
    // int cnt = 0;

    // for(int i=0;i<m;i++){
    // for(int j=0;j<n;j++){
    // if(grid[i][j]=='1'){
    // dfs(grid,i,j,m,n);
    // cnt++;
    // }
    // }
    // }
    // return cnt;
    // }

    // public void dfs(char[][] grid,int i, int j,int m,int n){
    // if(grid[i][j]=='0')return;
    // grid[i][j]='0';
    // // ��������
    // if(i>0)dfs(grid,i-1,j,m,n);
    // // ��������
    // if(j>0)dfs(grid,i,j-1,m,n);
    // // ��������
    // if(i<m-1)dfs(grid,i+1,j,m,n);
    // // ��������
    // if(j<n-1)dfs(grid,i,j+1,m,n);
    // }

    // bfs
    // public int numIslands(char[][] grid) {
    // int m = grid.length;
    // int n = grid[0].length;
    // int cnt = 0;

    // for(int i=0;i<m;i++){
    // for(int j=0;j<n;j++){
    // if(grid[i][j]=='1'){
    // cnt++;
    // Queue<int[]> queue = new LinkedList<int[]>();
    // grid[i][j]='0';
    // queue.offer(new int[]{i,j});
    // while(!queue.isEmpty()){
    // int[] pos = queue.poll();
    // int x = pos[0],y=pos[1];
    // if(x>0 && grid[x-1][y]=='1'){
    // queue.offer(new int[]{x-1,y});
    // grid[x-1][y]='0'; // ע��ֻҪ�ҵ���������б�ǣ���Ȼ������ܶ���ظ����
    // }
    // if(x<m-1 && grid[x+1][y]=='1'){
    // queue.offer(new int[]{x+1,y});
    // grid[x+1][y]='0';
    // }

    // if(y>0 && grid[x][y-1]=='1'){
    // queue.offer(new int[]{x,y-1});
    // grid[x][y-1]='0';
    // }
    // if(y<n-1 && grid[x][y+1]=='1'){
    // queue.offer(new int[]{x,y+1});
    // grid[x][y+1]='0';
    // }
    // }
    // }
    // }
    // }
    // return cnt;
    // }
}
