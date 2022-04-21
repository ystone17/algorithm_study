import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int ySize, xSize, count;
    static int[][] map, dp;
    static int[] dy = {0, 1, 0, -1};
    static int[] dx = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        ySize = Integer.parseInt(st.nextToken());
        xSize = Integer.parseInt(st.nextToken());
        map = new int[ySize][xSize];
        dp = new int[ySize][xSize];


        for (int i = 0; i < ySize; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < xSize; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
            Arrays.fill(dp[i], -1);
        }

        dp[0][0] = 1;
        dp[ySize - 1][xSize - 1] = 0;
        dfs(ySize - 1, xSize - 1);
        System.out.println(dp[ySize - 1][xSize - 1]);
    }

    static void dfs(int y, int x) {
        if(dp[y][x] == -1) dp[y][x] = 0;
        int height = map[y][x];

        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];

            if (ny < 0 || ny >= ySize || nx < 0 || nx >= xSize) continue;
            if (map[ny][nx] <= height) continue;

            if (dp[ny][nx] == -1) {
                dfs(ny, nx);
            }

            dp[y][x] += dp[ny][nx];
        }
    }
}
