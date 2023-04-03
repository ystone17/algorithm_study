import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuffer sb = new StringBuffer();

    static char[][] map;
    static int y, x, blue, white;
    static int[][] visited;
    static Queue<int[]> q = new LinkedList<>();
    static int[] dy = {0, 1, 0, -1};
    static int[] dx = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());

        map = new char[y][x];

        for (int i = 0; i < y; i++) {
            map[i] = br.readLine().toCharArray();
        }

        visited = new int[y][x];
        for (int i = 0; i < y; i++) {
            for (int j = 0; j < x; j++) {
                if (visited[i][j] == 1) continue;
                int res = bfs(i, j, map[i][j]);
                if (map[i][j] == 'B') {
                    blue += res;
                } else {
                    white += res;
                }
            }
        }

        System.out.printf("%d %d", white, blue);
    }

    static int bfs(int y, int x, char base) {
        int cnt = 0;
        q.add(new int[]{y, x});
        cnt++;
        visited[y][x] = 1;

        while (!q.isEmpty()) {
            int[] poll = q.poll();

            for (int i = 0; i < 4; i++) {
                int ny = poll[0] + dy[i];
                int nx = poll[1] + dx[i];

                if (ny < 0 || ny >= Main.y) continue;
                if (nx < 0 || nx >= Main.x) continue;
                if (visited[ny][nx] == 1) continue;
                if (map[ny][nx] != base) continue;

                q.add(new int[]{ny, nx});
                cnt++;
                visited[ny][nx] = 1;
            }
        }

        return cnt * cnt;
    }
}
