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

    static int yL, xL;
    static char[][] map;

    static int[] dy = {0, 1, 0, -1};
    static int[] dx = {1, 0, -1, 0};

    static Queue<Pos> q = new LinkedList<>();
    static int[][][] visited;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        yL = Integer.parseInt(st.nextToken());
        xL = Integer.parseInt(st.nextToken());

        map = new char[yL][xL];
        visited = new int[yL][xL][(1 << 6)];
        for (int y = 0; y < yL; y++) {
            map[y] = br.readLine().toCharArray();
            for (int x = 0; x < xL; x++) {
                if (map[y][x] == '0') {
                    q.add(new Pos(y, x, 0));
                    visited[y][x][0] = 1;
                }
            }
        }

        int time = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int z = 0; z < size; z++) {

                Pos cur = q.poll();
                if (map[cur.y][cur.x] == '1') {
                    System.out.println(time);
                    return;
                }

                for (int i = 0; i < 4; i++) {
                    int ny = cur.y + dy[i];
                    int nx = cur.x + dx[i];

                    if (ny < 0 || ny >= yL || nx < 0 || nx >= xL) continue;
                    if (map[ny][nx] == '#') continue;

                    Pos next = new Pos(ny, nx, cur.keys);
                    if (0 <= map[ny][nx] - 'A' && map[ny][nx] - 'A' < 6 && !next.hasKey(map[ny][nx] - 'A')) continue;
                    if (0 <= map[ny][nx] - 'a' && map[ny][nx] - 'a' < 6) next.addKey(map[ny][nx] - 'a');

                    if (visited[ny][nx][next.keys] == 1) continue;
                    visited[ny][nx][next.keys] = 1;
                    q.add(next);
                }
            }
            time++;
        }
        System.out.println(-1);
    }

    static class Pos {
        int y;
        int x;
        int keys;

        public Pos(int y, int x, int keys) {
            this.y = y;
            this.x = x;
            this.keys = keys;
        }

        void addKey(int key) {
            keys = keys | 1 << key;
        }

        boolean hasKey(int key) {
            return (keys & 1 << key) > 0;
        }
    }
}
