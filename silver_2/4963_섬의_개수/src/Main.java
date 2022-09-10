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

    static int h, w, island;
    static int[][] map, visited;
    static Queue<Pos> q;
    static int[] dy = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dx = {0, 1, 1, 1, 0, -1, -1, -1};

    public static void main(String[] args) throws IOException {
        while (true) {
            st = new StringTokenizer(br.readLine());

            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());

            if (h == 0 && w == 0) {
                System.out.println(sb);
                return;
            }

            map = new int[h][w];
            for (int i = 0; i < h; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < w; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            visited = new int[h][w];

            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    if (map[i][j] == 0 || visited[i][j] == 1) continue;
                    bfs(i, j);
                }
            }

            sb.append(island).append("\n");
            island = 0;
        }
    }

    static void bfs(int y, int x) {
        q = new LinkedList<>();

        q.add(new Pos(y, x));
        visited[y][x] = 1;

        while (!q.isEmpty()) {
            Pos cur = q.poll();

            for (int i = 0; i < 8; i++) {
                int ny = cur.y + dy[i];
                int nx = cur.x + dx[i];

                if (ny < 0 || ny >= h || nx < 0 || nx >= w) continue;
                if (map[ny][nx] == 0) continue;
                if (visited[ny][nx] == 1) continue;

                visited[ny][nx] = 1;
                q.add(new Pos(ny, nx));
            }
        }
        island++;
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
