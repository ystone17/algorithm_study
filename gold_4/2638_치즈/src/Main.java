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

    static int[][] map;
    static int y, x, time = -1;
    static int[] dy = {0, 1, 0, -1};
    static int[] dx = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        y = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        map = new int[y][x];

        for (int i = 0; i < y; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < x; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        Queue<Pos> q = new LinkedList<>();
        q.add(new Pos(0, 0));

        while (!q.isEmpty()) {
            time++;
            while (!q.isEmpty()) {
                Pos cur = q.poll();

                if (map[cur.y][cur.x] == -1) continue;
                map[cur.y][cur.x] = -1;

                for (int i = 0; i < 4; i++) {
                    int ny = cur.y + dy[i];
                    int nx = cur.x + dx[i];

                    if (ny < 0 || ny >= y || nx < 0 || nx >= x) continue;
                    if (map[ny][nx] != 0) continue;
                    q.add(new Pos(ny, nx));
                }
            }

            for (int i = 0; i < y; i++) {
                for (int j = 0; j < x; j++) {
                    if (map[i][j] != 1) continue;

                    int cnt = 0;
                    for (int k = 0; k < 4; k++) {
                        int ny = i + dy[k];
                        int nx = j + dx[k];

                        if (ny < 0 || ny >= y || nx < 0 || nx >= x) continue;
                        if (map[ny][nx] == -1) cnt++;
                    }
                    if (cnt >= 2) {
                        q.add(new Pos(i, j));
                    }

                }
            }
        }

        System.out.println(time);
    }

    private static class Pos {
        int y;
        int x;

        public Pos(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
}
