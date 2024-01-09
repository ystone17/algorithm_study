import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static final int E = 0, W = 1, S = 2, N = 3;

    static int n;
    static double[] percents = new double[4];
    static double res;
    static int[][] map = new int[30][30];
    static int[] dy = {0, 0, 1, -1};
    static int[] dx = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        percents[E] = Integer.parseInt(st.nextToken()) * 0.01;
        percents[W] = Integer.parseInt(st.nextToken()) * 0.01;
        percents[S] = Integer.parseInt(st.nextToken()) * 0.01;
        percents[N] = Integer.parseInt(st.nextToken()) * 0.01;

        map[15][15] = 1;
        dfs(15, 15, 0, 1);

        System.out.printf("%.10f ", res);
    }

    private static void dfs(int y, int x, int count, double total) {
        if (count >= n) {
            res += total;
            return;
        }

        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];

            if (ny < 0 || ny >= 30 || nx < 0 || nx >= 30) {
                continue;
            }

            if (map[ny][nx] == 1) {
                continue;
            }

            map[ny][nx] = 1;
            dfs(ny, nx, count + 1, total * percents[i]);
            map[ny][nx] = 0;
        }
    }


}
