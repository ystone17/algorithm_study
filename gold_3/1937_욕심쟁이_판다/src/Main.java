import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int n;
    static int[][] forest;
    static int[][] dp;
    static int[] dy = {0, 1, 0, -1};
    static int[] dx = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        forest = new int[n][n];
        dp = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                forest[i][j] = Integer.parseInt(st.nextToken());
                dp[i][j] = -1;
            }
        }

        int res = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (dp[i][j] != -1) continue;
                dp[i][j] = dfs(i, j);
                res = Math.max(res, dp[i][j]);
            }
        }

        System.out.println(res + 1);
    }

    static int dfs(int y, int x) {
        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];

            if (ny < 0 || ny >= n || nx < 0 || nx >= n || forest[y][x] <= forest[ny][nx]) continue;
            if (dp[ny][nx] != -1) {
                dp[y][x] = Math.max(dp[y][x], dp[ny][nx] + 1);
            } else {
                int res = dfs(ny, nx) + 1;
                dp[y][x] = Math.max(dp[y][x], res);
            }
        }

        if (dp[y][x] == -1) dp[y][x] = 0;

        return dp[y][x];
    }

    private static class Pos {
        int y;
        int x;

        public Pos(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
}
