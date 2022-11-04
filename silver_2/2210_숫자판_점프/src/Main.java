import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int[][] map = new int[5][5];
    static int[] seq = new int[6];
    static Set<Integer> set = new HashSet<>();

    static int[] dy = {0, 1, 0, -1};
    static int[] dx = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        for (int i = 0; i < 5; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                seq[0] = map[i][j];
                dfs(i, j, 1);
            }
        }
        System.out.println(set.size());
    }

    static void dfs(int y, int x, int idx) {
        if (idx >= 6) {
            int base = 100000;
            int res = 0;
            for (int i : seq) {
                res += i * base;
                base /= 10;
            }
            set.add(res);
            return;
        }

        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];

            if (ny < 0 || ny >= 5 || nx < 0 || nx >= 5) continue;

            seq[idx] = map[ny][nx];
            dfs(ny, nx, idx + 1);
        }

    }

}
