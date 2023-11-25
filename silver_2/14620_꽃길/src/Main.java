import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int n, max = Integer.MAX_VALUE;
    static int[][] map;
    static boolean[][] used;
    static int[] dy = {0, 1, 0, -1};
    static int[] dx = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        int base = n - 2;

        map = new int[n][n];
        used = new boolean[n][n];

        for (int y = 0; y < n; y++) {
            st = new StringTokenizer(br.readLine());
            for (int x = 0; x < n; x++) {
                map[y][x] = Integer.parseInt(st.nextToken());
            }
        }

        int total = 0;
        for (int a = 0; a < base * base; a++) {
            int ay = a / base + 1;
            int ax = a % base + 1;
            if (isUsed(ay, ax)) {
                continue;
            }

            total += setUsed(ay, ax, true);

            for (int b = 0; b < base * base; b++) {
                int by = b / base + 1;
                int bx = b % base + 1;
                if (isUsed(by, bx)) {
                    continue;
                }

                total += setUsed(by, bx, true);

                for (int c = 0; c < base * base; c++) {
                    int cy = c / base + 1;
                    int cx = c % base + 1;
                    if (isUsed(cy, cx)) {
                        continue;
                    }

                    total += setUsed(cy, cx, true);
                    max = Math.min(max, total);
                    total -= setUsed(cy, cx, false);
                }
                total -= setUsed(by, bx, false);
            }
            total -= setUsed(ay, ax, false);
        }

        System.out.println(max);
    }

    static boolean isUsed(int y, int x) {
        if (used[y][x]) {
            return true;
        }

        for (int dir = 0; dir < 4; dir++) {
            int ny = y + dy[dir];
            int nx = x + dx[dir];

            if (used[ny][nx]) {
                return true;
            }
        }

        return false;
    }

    static int setUsed(int y, int x, boolean use) {
        int total = 0;

        used[y][x] = use;
        total += map[y][x];
        for (int dir = 0; dir < 4; dir++) {
            int ny = y + dy[dir];
            int nx = x + dx[dir];

            used[ny][nx] = use;
            total += map[ny][nx];
        }

        return total;
    }
}
