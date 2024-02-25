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

    static char[][] map;
    static boolean[][][] visited;
    static int xLen, yLen, xNumber;

    static Queue<Pos> q = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        xLen = Integer.parseInt(st.nextToken());
        yLen = Integer.parseInt(st.nextToken());

        map = new char[yLen][xLen];
        visited = new boolean[32][yLen][xLen];

        for (int y = 0; y < yLen; y++) {
            map[y] = br.readLine().toCharArray();
        }

        for (int y = 0; y < yLen; y++) {
            for (int x = 0; x < xLen; x++) {
                if (map[y][x] == 'S') {
                    q.add(new Pos(y, x, 0));
                    visited[0][y][x] = true;
                }

                if (map[y][x] == 'X') {
                    map[y][x] = (char) ('0' + xNumber++);
                }
            }
        }

        var time = 0;
        while (!q.isEmpty()) {
            var size = q.size();
            for (int i = 0; i < size; i++) {
                var cur = q.poll();
                if (map[cur.y][cur.x] == 'E') {
                    if (cur.pocket == (1 << xNumber) - 1) {
                        System.out.println(time);
                        return;
                    }

                    continue;
                }

                for (int dir = 0; dir < 4; dir++) {
                    int ny = cur.y + dy[dir];
                    int nx = cur.x + dx[dir];

                    if (ny < 0 || ny >= yLen || nx < 0 || nx >= xLen) {
                        continue;
                    }
                    if (map[ny][nx] == '#') {
                        continue;
                    }

                    if (map[ny][nx] - '0' >= 0 && map[ny][nx] - '0' <= xNumber) {
                        var pocketEl = 1 << map[ny][nx] - '0';
                        if (visited[cur.pocket | pocketEl][ny][nx]) {
                            continue;
                        }
                        visited[cur.pocket | pocketEl][ny][nx] = true;
                        q.add(new Pos(ny, nx, cur.pocket | pocketEl));
                    } else {
                        if (visited[cur.pocket][ny][nx]) {
                            continue;
                        }
                        visited[cur.pocket][ny][nx] = true;
                        q.add(new Pos(ny, nx, cur.pocket));
                    }


                }
            }
            time++;
        }

    }

    static class Pos {
        int y;
        int x;
        int pocket;

        public Pos(int y, int x, int pocket) {
            this.y = y;
            this.x = x;
            this.pocket = pocket;
        }
    }
}
