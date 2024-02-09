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

    static int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};
    static int[] dx = {1, 1, 0, -1, -1, -1, 0, 1};

    static int h, w, res;
    static char[][] map;
    static Queue<Pos> q = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());

        h = Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken());

        map = new char[h][w];

        for (int i = 0; i < h; i++) {
            map[i] = br.readLine().toCharArray();
        }

        for (int y = 0; y < h; y++) {
            for (int x = 0; x < w; x++) {
                if (map[y][x] == '.') {
                    continue;
                }

                if (canDelete(y, x, map[y][x] - '0')) {
                    q.add(new Pos(y, x));
                }
            }
        }

        while (!q.isEmpty()) {
            var size = q.size();
            for (int i = 0; i < size; i++) {
                var cur = q.peek();
                map[cur.y][cur.x] = '.';
                q.add(q.poll());
            }

            res++;

            size = q.size();
            for (int i = 0; i < size; i++) {
                var cur = q.poll();

                for (int dir = 0; dir < 8; dir++) {
                    int ny = cur.y + dy[dir];
                    int nx = cur.x + dx[dir];

                    if (ny < 0 || ny >= h || nx < 0 || nx >= w) {
                        continue;
                    }

                    if (map[ny][nx] == '.') {
                        continue;
                    }

                    if (canDelete(ny, nx, map[ny][nx] - '0')) {
                        q.add(new Pos(ny, nx));
                    }
                }
            }
        }

        System.out.println(res);

    }

    static boolean canDelete(int y, int x, int health) {
        var sandCount = 0;

        for (int dir = 0; dir < 8; dir++) {
            int ny = y + dy[dir];
            int nx = x + dx[dir];

            if (ny < 0 || ny >= h || nx < 0 || nx >= w) {
                continue;
            }

            if (map[ny][nx] == '.') {
                sandCount++;
            }
        }

        return sandCount >= health;
    }

    static class Pos {
        int y;
        int x;

        public Pos(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
}
