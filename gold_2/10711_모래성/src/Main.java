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
    static int[][] counts;
    static boolean[][] visited;
    static Queue<Pos> q = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());

        h = Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken());

        map = new char[h][w];
        counts = new int[h][w];
        visited = new boolean[h][w];

        for (int i = 0; i < h; i++) {
            map[i] = br.readLine().toCharArray();
        }

        for (int y = 0; y < h; y++) {
            for (int x = 0; x < w; x++) {
                if (map[y][x] == '.') {
                    continue;
                }

                counts[y][x] = getSendCount(y, x);
                if (counts[y][x] >= map[y][x] - '0') {
                    q.add(new Pos(y, x));
                    visited[y][x] = true;
                }
            }
        }

        while (!q.isEmpty()) {
            res++;

            var size = q.size();
            for (int i = 0; i < size; i++) {
                var cur = q.poll();
                map[cur.y][cur.x] = '.';

                for (int dir = 0; dir < 8; dir++) {
                    int ny = cur.y + dy[dir];
                    int nx = cur.x + dx[dir];

                    if (ny < 0 || ny >= h || nx < 0 || nx >= w) {
                        continue;
                    }

                    if (visited[ny][nx]) {
                        continue;
                    }

                    if (map[ny][nx] == '.') {
                        continue;
                    }

                    if (++counts[ny][nx] >= map[ny][nx] - '0') {
                        q.add(new Pos(ny, nx));
                        visited[ny][nx] = true;
                    }
                }
            }
        }

        System.out.println(res);

    }

    static int getSendCount(int y, int x) {
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

        return sandCount;
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
