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
    static int yLen, xLen, answer;
    static int[][] map;
    static int[][][] visited;
    static Pos[] startAndEnd = new Pos[2];
    static int[] dy = {0, 1, 0, -1};
    static int[] dx = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        read();
        bfs();
        System.out.println(answer);
    }

    private static void bfs() {
        Queue<Pos> q = new LinkedList<>();
        q.add(startAndEnd[0]);
        visited[startAndEnd[0].y][startAndEnd[0].x][startAndEnd[0].dir] = 1;

        while (!q.isEmpty()) {
            int size = q.size();
            for (int s = 0; s < size; s++) {
                Pos cur = q.poll();

                if (cur.y == startAndEnd[1].y && cur.x == startAndEnd[1].x && cur.dir == startAndEnd[1].dir) {
                    return;
                }

                boolean[] go = new boolean[3];
                int ny = cur.y;
                int nx = cur.x;
                for (int k = 0; k < 3; k++) {
                    ny += dy[cur.dir];
                    nx += dx[cur.dir];
                    if (ny < 0 || ny >= yLen || nx < 0 || nx >= xLen) break;
                    if (map[ny][nx] == 1) break;
                    if (visited[ny][nx][cur.dir] == 1) continue;
                    go[k] = true;
                }

                for (int k = 0; k < 3; k++) {
                    if (go[k]) {
                        visited[cur.y + dy[cur.dir] * (k + 1)][cur.x + dx[cur.dir] * (k + 1)][cur.dir] = 1;
                        q.add(new Pos(cur.y + dy[cur.dir] * (k + 1), cur.x + dx[cur.dir] * (k + 1), cur.dir));
                    }
                }

                for (int i = -1; i < 2; i += 2) {
                    if (visited[cur.y][cur.x][(cur.dir + i + 4) % 4] == 0) {
                        visited[cur.y][cur.x][(cur.dir + i + 4) % 4] = 1;
                        q.add(new Pos(cur.y, cur.x, (cur.dir + i + 4) % 4));
                    }
                }

            }
            answer++;
        }

    }

    private static void read() throws IOException {
        st = new StringTokenizer(br.readLine());
        yLen = Integer.parseInt(st.nextToken());
        xLen = Integer.parseInt(st.nextToken());
        map = new int[yLen][xLen];
        visited = new int[yLen][xLen][4];
        for (int y = 0; y < yLen; y++) {
            st = new StringTokenizer(br.readLine());
            for (int x = 0; x < xLen; x++) {
                map[y][x] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 0; i < 2; i++) {
            st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int dir = Integer.parseInt(st.nextToken());
            switch (dir) {
                case 1:
                    dir = 0;
                    break;
                case 3:
                    dir = 1;
                    break;
                case 4:
                    dir = 3;
                    break;
            }
            startAndEnd[i] = new Pos(y - 1, x - 1, dir);
        }
    }

    static class Pos {
        int y;
        int x;
        // e 1, w 2, s 3, n 4;
        int dir;

        public Pos(int y, int x, int dir) {
            this.y = y;
            this.x = x;
            this.dir = dir;
        }
    }
}
