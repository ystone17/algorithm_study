import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int n, m, k, answer;
    static char[] goal;
    static char[][] map;
    static int[][][] dp;
    static int[] dy = {0, 1, 0, -1};
    static int[] dx = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        map = new char[n][m];

        for (int i = 0; i < n; i++) {
            map[i] = br.readLine().toCharArray();
        }

        goal = br.readLine().toCharArray();
        dp = new int[goal.length][n][m];
        for (int[][] dp1 : dp) {
            for (int[] dp2 : dp1) {
                Arrays.fill(dp2, -1);
            }
        }


        for (int y = 0; y < map.length; y++) {
            for (int x = 0; x < map[y].length; x++) {
                if (map[y][x] == goal[0]) {
                    answer += dfs(y, x, 0);
                }
            }
        }

        System.out.println(answer);
    }

    static int dfs(int y, int x, int idx) {
        if (idx == goal.length - 1) {
            return dp[idx][y][x] = 1;
        }

        if (dp[idx][y][x] != -1) {
            return dp[idx][y][x];
        }

        int ny, nx;

        dp[idx][y][x] = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = 1; j <= k; j++) {
                ny = y + dy[i] * j;
                nx = x + dx[i] * j;

                if (ny < 0 || ny >= n || nx < 0 || nx >= m) continue;
                if (map[ny][nx] != goal[idx + 1]) continue;

                dp[idx][y][x] += dfs(ny, nx, idx + 1);
            }
        }

        return dp[idx][y][x];
    }
}
