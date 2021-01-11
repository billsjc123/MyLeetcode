public class Leetcode_834 {
    public int[] sumOfDistancesInTree(int N, int[][] edges) {
        int[][] dist = new int[N][N];
        for (int[] edge : edges) {
            dist[edge[0]][edge[1]] = 1;
            dist[edge[1]][edge[0]] = 1;
        }

        for (int i = 0; i < N; i++) {
            int[] visited = new int[N];
            int cnt = 1;
            visited[i] = 1;
            for (int j = 0; cnt < N; j = (j + 1) % N) {
                if (j == i)
                    continue;
                if (dist[i][j] > 0) {
                    if (visited[j] == 0) {
                        visited[j] = 1;
                        cnt++;
                    }
                    continue;
                }
                for (int k = 0; k < N; k++) {
                    if (dist[i][k] > 0 && dist[k][j] > 0) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                        dist[j][i] = dist[i][j];
                        visited[j] = 1;
                        cnt++;
                        break;
                    }
                }
            }
        }

        int[] ans = new int[N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(i!=j)
                    ans[i] += dist[i][j];
            }
        }
        return ans;
    }
}
