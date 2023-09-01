import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int yLen, xLen, res = -1;
    static int[][] map, dist;
    static Queue<Position> q = new LinkedList<>();
    static int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};
    static int[] dx = {1, 1, 0, -1, -1, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());

        yLen = Integer.parseInt(st.nextToken());
        xLen = Integer.parseInt(st.nextToken());

        map = new int[yLen][xLen];
        for (int y = 0; y < yLen; y++) {
            st = new StringTokenizer(br.readLine());
            for (int x = 0; x < xLen; x++) {
                map[y][x] = Integer.parseInt(st.nextToken());
                if (map[y][x] == 1) {
                    q.add(new Position(y, x));
                }
            }
        }

        dist = new int[yLen][xLen];
        for (int y = 0; y < yLen; y++) {
            Arrays.fill(dist[y], Integer.MAX_VALUE);
        }
        int d = 1;

        while (!q.isEmpty()) {
            int size = q.size();

            while (size-- > 0) {
                Position cur = q.poll();

                for (int dir = 0; dir < 8; dir++) {
                    int ny = cur.y + dy[dir];
                    int nx = cur.x + dx[dir];

                    if (ny < 0 || ny >= yLen || nx < 0 || nx >= xLen) {
                        continue;
                    }

                    if (dist[ny][nx] <= d) {
                        continue;
                    }

                    if (map[ny][nx] == 1) {
                        continue;
                    }

                    dist[ny][nx] = d;
                    q.add(new Position(ny, nx));
                }
            }
            d++;
        }

        for (int y = 0; y < yLen; y++) {
            for (int x = 0; x < xLen; x++) {
                res = Math.max(res, dist[y][x] == Integer.MAX_VALUE ? 0 : dist[y][x]);
            }
        }

        System.out.println(res);
    }

    static class Position {
        int y;
        int x;

        public Position(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
}
