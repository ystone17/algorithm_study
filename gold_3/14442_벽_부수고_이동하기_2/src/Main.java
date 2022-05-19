import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int yLen, xLen, brokenLen, answer = -1;
    static int[][] map;
    static int[][][] visited;
    static int[] dy = {0, 1, 0, -1};
    static int[] dx = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());

        yLen = Integer.parseInt(st.nextToken());
        xLen = Integer.parseInt(st.nextToken());
        brokenLen = Integer.parseInt(st.nextToken());

        map = new int[yLen][xLen];
        for (int y = 0; y < yLen; y++) {
            String[] row = br.readLine().split("");
            for (int x = 0; x < xLen; x++) {
                map[y][x] = Integer.parseInt(row[x]);
            }
        }
        visited = new int[brokenLen + 1][yLen][xLen];
        bfs();
        System.out.println(answer);
    }

    private static void bfs() {
        Queue<Pos> q = new LinkedList<>();

        q.add(new Pos(0, 0, 0));
        visited[0][0][0] = 1;

        int dist = 0;

        while (!q.isEmpty()) {
            dist++;
            int size = q.size();
            for (int s = 0; s < size; s++) {
                Pos cur = q.poll();

                if (cur.y == yLen - 1 && cur.x == xLen - 1) {
                    answer = dist;
                    return;
                }

                for (int i = 0; i < 4; i++) {
                    int ny = cur.y + dy[i];
                    int nx = cur.x + dx[i];

                    if (ny < 0 || ny >= yLen || nx < 0 || nx >= xLen) continue;
                    if (cur.brokenCnt < brokenLen && map[ny][nx] == 1 && visited[cur.brokenCnt + 1][ny][nx] == 0) {
                        visited[cur.brokenCnt + 1][ny][nx] = 1;
                        q.add(new Pos(ny, nx, cur.brokenCnt + 1));
                        continue;
                    }

                    if (map[ny][nx] == 0 && visited[cur.brokenCnt][ny][nx] == 0) {
                        visited[cur.brokenCnt][ny][nx] = 1;
                        q.add(new Pos(ny, nx, cur.brokenCnt));
                    }
                }
            }
        }
    }

    static class Pos {
        int y;
        int x;
        int brokenCnt;

        public Pos(int y, int x, int brokenCnt) {
            this.y = y;
            this.x = x;
            this.brokenCnt = brokenCnt;
        }
    }
}
