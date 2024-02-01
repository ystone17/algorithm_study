import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int n, k, min = 1_000_000_000;
    static int[][] map;
    static int[] used;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        map = new int[n][n];
        for (int y = 0; y < n; y++) {
            st = new StringTokenizer(br.readLine());
            for (int x = 0; x < n; x++) {
                map[y][x] = Integer.parseInt(st.nextToken());
                if (y == x) {
                    map[y][x] = 1_000_000_000;
                }
            }
        }

        for (int s = 0; s < n; s++) {
            for (int e = 0; e < n; e++) {
                if (s == e) {
                    continue;
                }
                for (int m = 0; m < n; m++) {

                    if (map[s][e] > map[s][m] + map[m][e]) {
                        map[s][e] = map[s][m] + map[m][e];
                    }

                }
            }
        }

        used = new int[n];
        used[k] = 1;
        dfs(0, k, 0);
        System.out.println(min);
    }

    static void dfs(int count, int parent, int total) {
        if (count >= n - 1) {
            min = Math.min(min, total);
            return;
        }

        if (total >= min) {
            return;
        }

        for (int child = 0; child < n; child++) {
            if (used[child] == 1) {
                continue;
            }
            used[child] = 1;
            dfs(count + 1, child, total + map[parent][child]);
            used[child] = 0;
        }
    }

}
