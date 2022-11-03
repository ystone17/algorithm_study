import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int n;
    static int[][] map;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());

        map = new int[n][n];
        dp = new int[n][(1 << n) - 1];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(TSP(0, 1));

    }

    static int TSP(int now, int route) {
        if (route == dp[0].length) {
            return map[now][0] == 0 ? 987654321 : map[now][0];
        }
        if (dp[now][route] != -1) {
            return dp[now][route];
        }


        dp[now][route] = 987654321;

        for (int next = 0; next < map[now].length; next++) {
            if (map[now][next] == 0) continue;
            if (!visited(route, next)) {
                int nextRoute = addRoute(route, next);
                dp[now][route] = Math.min(dp[now][route], TSP(next, nextRoute) + map[now][next]);
            }
        }

        return dp[now][route];
    }

    static int addRoute(int route, int next) {
        return route | 1 << next;
    }

    static boolean visited(int route, int next) {
        return (route & 1 << next) > 0;
    }
}
