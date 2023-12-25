import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int n, m;
    static char[][] map;
    static boolean[][] visited;
    static int[] dy = {1, 0, -1, 0};
    static int[] dx = {0, -1, 0, 1};
    static Queue<Pos> q = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new char[n][m];
        for (int i = 0; i < n; i++) {
            map[i] = br.readLine().toCharArray();
        }

        visited = new boolean[n][m];

        for (int x = 0; x < m; x++) {
            if (map[0][x] == '1') continue;
            if (visited[0][x]) continue;
            visited[0][x] = true;

            q.add(new Pos(0, x));
            while (!q.isEmpty()) {
                Pos cur = q.poll();

                if (cur.y == n - 1) {
                    System.out.println("YES");
                    return;
                }

                for (int dir = 0; dir < 4; dir++) {
                    int ny = cur.y + dy[dir];
                    int nx = cur.x + dx[dir];

                    if (ny < 0 || ny >= n || nx < 0 || nx >= m) continue;
                    if (map[ny][nx] == '1') continue;
                    if (visited[ny][nx]) continue;

                    visited[ny][nx] = true;

                    q.add(new Pos(ny, nx));
                }
            }
        }


        System.out.println("NO");
    }

    private static class Pos {
        int y;
        int x;

        public Pos(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
}
