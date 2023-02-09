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

    static Queue<Pos> q = new LinkedList<>();
    static char[][] map;
    static boolean[][][] visited;
    static Pos start;

    static int ySize, xSize, dirtyNum;

    public static void main(String[] args) throws IOException {
        while (true) {
            st = new StringTokenizer(br.readLine());
            xSize = Integer.parseInt(st.nextToken());
            ySize = Integer.parseInt(st.nextToken());

            if (ySize == 0) break;

            q = new LinkedList<>();
            map = new char[ySize][xSize];


            for (int y = 0; y < ySize; y++) {
                char[] row = br.readLine().toCharArray();

                for (int x = 0; x < xSize; x++) {
                    map[y][x] = row[x];
                    if (map[y][x] == 'o') start = new Pos(y, x, 0);
                    if (map[y][x] == '*') {
                        map[y][x] = (char) ('a' + dirtyNum);
                        dirtyNum++;
                    }
                }
            }

            visited = new boolean[1 << dirtyNum][ySize][xSize];

            visited[0][start.y][start.x] = true;
            System.out.println(bfs());
        }
    }

    private static int bfs() {
        q.add(start);

        int move = -1;
        while (!q.isEmpty()) {
            move++;
            int size = q.size();

            for (int s = 0; s < size; s++) {
                Pos cur = q.poll();

                if (map[cur.y][cur.x] != 'x') {
                    cur.bit += 1 << (map[cur.y][cur.x] - 'a');
                }

                if (cur.bit == (1 << dirtyNum) -1) {
                    return move;
                }

                for (int i = 0; i < 4; i++) {
                    int ny = cur.y + dy[i];
                    int nx = cur.x + dx[i];

                    if (ny < 0 || ny >= ySize || nx < 0 || nx >= xSize) continue;
                    if (visited[cur.bit][ny][nx]) continue;
                    if (map[ny][nx] == 'x') continue;

                    Pos next = new Pos(ny, nx, cur.bit);

                    visited[cur.bit][ny][nx] = true;
                    q.add(next);
                }
            }
        }
        return -1;
    }

    static class Pos {
        int y;
        int x;
        int bit;

        public Pos(int y, int x, int bit) {
            this.y = y;
            this.x = x;
            this.bit = bit;
        }
    }
}
