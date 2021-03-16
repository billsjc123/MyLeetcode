public class Leetcode_463 {
    int ans=0;
    boolean[][] visited;
    public int islandPerimeter(int[][] grid) {
        visited = new boolean[grid.length][grid[0].length];
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1){
                    dfs(grid,i,j);
                    return ans;
                }
            }
        }
        return 0;
    }

    public int dfs(int[][] grid,int i,int j){
        if(grid[i][j]==0)return 0;
        if(visited[i][j])return 1;
        visited[i][j]=true;
        int neighbors = 0;
        if(i>0)neighbors+=dfs(grid,i-1,j);
        if(j>0)neighbors+=dfs(grid,i,j-1);
        if(i<grid.length-1)neighbors+=dfs(grid,i+1,j);
        if(j<grid[0].length-1)neighbors+=dfs(grid,i,j+1);
        ans+=4-neighbors;
        return 1;
    }
}
