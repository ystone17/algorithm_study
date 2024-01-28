import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb;

    static int yLen, xLen, limitT;
    static int[][] map;
    static int[][][] visited;
    static Queue<Pos> q = new LinkedList<>();

    static int[] dy = {0, 1, 0, -1};
    static int[] dx = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());

        yLen = Integer.parseInt(st.nextToken());
        xLen = Integer.parseInt(st.nextToken());
        limitT = Integer.parseInt(st.nextToken());

        map = new int[yLen][xLen];
        for (int y = 0; y < yLen; y++) {
            st = new StringTokenizer(br.readLine());
            for (int x = 0; x < xLen; x++) {
                map[y][x] = Integer.parseInt(st.nextToken());
            }
        }


        visited = new int[2][yLen][xLen];

        q.add(new Pos(0, 0, false));
        visited[0][0][0] = 1;

        int t = 0;
        while (!q.isEmpty()) {
            var size = q.size();
            for (int i = 0; i < size; i++) {
                if (t > limitT) {
                    q.clear();
                    break;
                }

                var cur = q.poll();
                if (cur.y == yLen - 1 && cur.x == xLen - 1) {
                    System.out.println(t);
                    return;
                }
                cur.swordMount = cur.swordMount || map[cur.y][cur.x] == 2;

                for (int dir = 0; dir < 4; dir++) {
                    int ny = cur.y + dy[dir];
                    int nx = cur.x + dx[dir];

                    if (ny >= yLen || ny < 0 || nx >= xLen || nx < 0) {
                        continue;
                    }

                    if (cur.swordMount) {
                        if (visited[1][ny][nx] == 1) {
                            continue;
                        }
                        visited[1][ny][nx] = 1;
                    } else {
                        if (visited[0][ny][nx] == 1) {
                            continue;
                        }

                        if (map[ny][nx] == 1) {
                            continue;
                        }
                        visited[0][ny][nx] = 1;
                    }

                    q.add(new Pos(ny, nx, cur.swordMount));
                }
            }
            t++;
        }

        System.out.println("Fail");
    }

    static class Pos {
        int y;
        int x;
        boolean swordMount;

        public Pos(int y, int x, boolean swordMount) {
            this.y = y;
            this.x = x;
            this.swordMount = swordMount;
        }
    }
}
