import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[] dy = {0, 1, 0, -1};
    static int[] dx = {1, 0, -1, 0};
    static char[][] map;
    static int[][] visited;
    static int x, y;
    static int[][] cPos = new int[2][2];

    public static void main(String[] args) throws IOException {
        read();
        bfs();
        System.out.println(visited[cPos[1][0]][cPos[1][1]]);
    }

    private static void read() throws IOException {
        st = new StringTokenizer(br.readLine());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());

        visited = new int[y][x];
        for (int[] ints : visited) {
            Arrays.fill(ints, Integer.MAX_VALUE);
        }
        map = new char[y][x];
        int idx = 0;
        for (int i = 0; i < y; i++) {
            char[] row = br.readLine().toCharArray();
            for (int j = 0; j < x; j++) {
                map[i][j] = row[j];
                if (map[i][j] == 'C') {
                    cPos[idx][0] = i;
                    cPos[idx][1] = j;
                    idx++;
                }
            }
        }
    }

    private static void bfs() {
        Queue<Pos> q = new LinkedList<>();

        q.add(new Pos(cPos[0][0], cPos[0][1], -1, -1));
        visited[cPos[0][0]][cPos[0][1]] = 0;

        while (!q.isEmpty()) {
            Pos cur = q.poll();

            if (cur.y == cPos[1][0] && cur.x == cPos[1][1]) {
                continue;
            }

            for (int i = 0; i < 4; i++) {
                int ny = cur.y + dy[i];
                int nx = cur.x + dx[i];
                int nCnt = cur.cnt;
                if (cur.dir != i) nCnt++;

                if (ny < 0 || ny >= y || nx < 0 || nx >= x) continue;
                if (visited[ny][nx] < nCnt) continue;
                if (map[ny][nx] == '*') continue;

                visited[ny][nx] = nCnt;
                q.add(new Pos(ny, nx, i, nCnt));
            }

        }
    }

    static class Pos {
        int y;
        int x;
        int dir;
        int cnt;

        public Pos(int y, int x, int dir, int cnt) {
            this.y = y;
            this.x = x;
            this.dir = dir;
            this.cnt = cnt;
        }
    }
}
