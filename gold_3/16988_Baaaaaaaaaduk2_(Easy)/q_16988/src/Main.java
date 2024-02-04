import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;


    private static int yLen, xLen, max = -1;
    private static int[][] map, visitd;

    private static int[] dy = {0, 0, 1, -1};
    private static int[] dx = {1, -1, 0, 0};

    private static Queue<Pos> q = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());

        yLen = Integer.parseInt(st.nextToken()) + 2;
        xLen = Integer.parseInt(st.nextToken()) + 2;
        map = new int[yLen][xLen];
        visitd = new int[yLen][xLen];

        for (int i = 0; i < yLen; i++) {
            Arrays.fill(map[i], 1);
        }

        for (int i = 1; i < yLen - 1; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j < xLen - 1; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int s = 0; s < yLen * xLen; s++) {
            int sy = s / xLen;
            int sx = s % xLen;

            if (map[sy][sx] != 0) {
                continue;
            }
            map[sy][sx] = 1;

            for (int e = s + 1; e < yLen * xLen; e++) {
                int ey = e / xLen;
                int ex = e % xLen;

                if (map[ey][ex] != 0) {
                    continue;
                }
                map[ey][ex] = 1;
                var temp = 0;
                visitd = new int[yLen][xLen];

                for (int y = 1; y < yLen - 1; y++) {
                    for (int x = 1; x < xLen - 1; x++) {
                        if (visitd[y][x] == 1 || map[y][x] != 2) {
                            continue;
                        }

                        temp += captureCount(y, x);

                    }
                }

                max = Math.max(max, temp);
                map[ey][ex] = 0;
            }

            map[sy][sx] = 0;
        }

        System.out.println(max);
    }

    static int captureCount(int y, int x) {
        q.clear();
        var nearZero = false;
        var count = 0;

        q.add(new Pos(y, x));
        visitd[y][x] = 1;

        while (!q.isEmpty()) {
            var cur = q.poll();
            count++;

            for (int dir = 0; dir < 4; dir++) {
                int ny = cur.y + dy[dir];
                int nx = cur.x + dx[dir];

                if (ny < 0 || ny >= yLen || nx < 0 || nx >= xLen) {
                    continue;
                }
                if (visitd[ny][nx] == 1) {
                    continue;
                }
                if (map[ny][nx] == 1) {
                    continue;
                }

                if (map[ny][nx] == 0) {
                    nearZero = true;
                    continue;
                }

                visitd[ny][nx] = 1;
                q.add(new Pos(ny, nx));
            }
        }

        return nearZero ? 0 : count;
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
