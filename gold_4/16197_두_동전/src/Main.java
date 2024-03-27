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

    static int[] dy = {0, 1, 0, -1};
    static int[] dx = {1, 0, -1, 0};

    static int h, w;
    static char[][] map;
    static boolean[][][][] visited;
    static Queue<Pos> q = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        h = Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken());
        map = new char[h][w];
        visited = new boolean[h][w][h][w];

        for (int y = 0; y < h; y++) {
            map[y] = br.readLine().toCharArray();
        }

        for (int y = 0; y < h; y++) {
            for (int x = 0; x < w; x++) {
                if (map[y][x] == 'o') {
                    q.add(new Pos(y, x));
                }
            }
        }


        int time = 0;
        while (time < 10) {
            time++;
            var size = q.size();
            for (int i = 0; i < size; i += 2) {
                var pos1 = q.poll();
                var pos2 = q.poll();

                for (int dir = 0; dir < 4; dir++) {
                    var outCount = 0;

                    var ny1 = pos1.y + dy[dir];
                    var nx1 = pos1.x + dx[dir];

                    if (ny1 < 0 || ny1 >= h || nx1 < 0 || nx1 >= w) {
                        outCount++;
                    } else if (map[ny1][nx1] == '#') {
                        ny1 = pos1.y;
                        nx1 = pos1.x;
                    }


                    var ny2 = pos2.y + dy[dir];
                    var nx2 = pos2.x + dx[dir];

                    if (ny2 < 0 || ny2 >= h || nx2 < 0 || nx2 >= w) {
                        outCount++;
                    } else if (map[ny2][nx2] == '#') {
                        ny2 = pos2.y;
                        nx2 = pos2.x;
                    }

                    if (outCount == 1) {
                        System.out.println(time);
                        return;
                    }

                    if (outCount == 2) {
                        continue;
                    }

                    if (ny1 == ny2 && nx1 == nx2) {
                        continue;
                    }

                    if (visited[ny1][nx1][ny2][nx2]) {
                        continue;
                    }

                    visited[ny1][nx1][ny2][nx2] = true;
                    q.add(new Pos(ny1, nx1));
                    q.add(new Pos(ny2, nx2));
                }
            }
        }

        System.out.println(-1);
    }

    static class Pos {
        int y;
        int x;

        public Pos(int y, int x) {
            this.y = y;
            this.x = x;
        }

        @Override
        public String toString() {
            return "Pos{" +
                    "y=" + y +
                    ", x=" + x +
                    '}';
        }
    }
}
