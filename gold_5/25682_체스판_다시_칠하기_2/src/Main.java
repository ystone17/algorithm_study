import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int n, m, k;
    static char[][] map;
    static long[][] black, white;

    public static void main(String[] args) throws IOException {
        init();

        black = new long[n + 1][m + 1];
        partSum(black, 0);

        white = new long[n + 1][m + 1];
        partSum(white, 1);

        solve();

    }

    private static void init() throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        map = new char[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            int j = 1;
            for (char c : br.readLine().toCharArray()) {
                map[i][j++] = c;
            }
        }
    }

    private static void partSum(long[][] sum, int baseIdx) {
        char[] base = {'B', 'W'};
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                sum[i][j] = sum[i - 1][j] + sum[i][j - 1] - sum[i - 1][j - 1] + (map[i][j] == base[baseIdx] ? 0 : 1);
                baseIdx = (baseIdx + 1) % 2;
            }
            if (m % 2 == 0) baseIdx = (baseIdx + 1) % 2;
        }
    }

    private static void solve() {
        long min = Integer.MAX_VALUE;
        for (int i = k; i <= n; i++) {
            for (int j = k; j <= m; j++) {
                min = Math.min(min, Math.min(calc(black, i, j), calc(white, i, j)));
            }
        }

        System.out.println(min);
    }

    private static long calc(long[][] sum, int y, int x) {
        return sum[y][x] - sum[y - k][x] - sum[y][x - k] + sum[y - k][x - k];
    }
}
