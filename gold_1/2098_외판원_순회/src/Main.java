import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int n, completeRoute;
    static int[][] map, dp;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());

        map = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        completeRoute = (1 << n) - 1;
        dp = new int[n][completeRoute];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }

        int tsp = tsp(0, 1);
        System.out.println(tsp);
    }

    //traveling salesman problem
    static int tsp(int now, int route) {
        if (route == completeRoute) {
            if (map[now][0] == 0) {
                return 987654321;
            } else {
                return map[now][0];
            }
        }

        if (dp[now][route] != -1) {
            return dp[now][route];
        }

        dp[now][route] = 987654321;

        for (int i = 0; i < n; i++) {
            if(i == now) continue;
            int nextRoute = route | (1 << i);

            if (map[now][i] == 0 || (route & (1 << i)) != 0) continue;

            dp[now][route] = Math.min(dp[now][route], tsp(i, nextRoute) + map[now][i]);
        }


        return dp[now][route];
    }
}
