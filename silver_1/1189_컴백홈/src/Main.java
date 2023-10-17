import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int r, c, k, ey, ex, res;
    static char[][] map;
    static boolean[][] visited;
    static int[] dy = {0, 1, 0, -1};
    static int[] dx = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        map = new char[r][c];

        for (int i = 0; i < r; i++) {
            map[i] = br.readLine().toCharArray();
        }

        visited = new boolean[r][c];
        ey = 0;
        ex = c - 1;
        visited[r - 1][0] = true;

        dfs(r - 1, 0, 1);
        System.out.println(res);
    }

    static void dfs(int y, int x, int cnt) {
        if (y == ey && x == ex) {
            if (cnt == k) {
                res++;
            }
            return;
        }

        for (int dir = 0; dir < 4; dir++) {
            int ny = y + dy[dir];
            int nx = x + dx[dir];

            if (ny < 0 || ny >= r || nx < 0 || nx >= c) {
                continue;
            }

            if (visited[ny][nx]) {
                continue;
            }

            if (map[ny][nx] == 'T') {
                continue;
            }

            visited[ny][nx] = true;
            dfs(ny, nx, cnt + 1);
            visited[ny][nx] = false;
        }
    }
}
