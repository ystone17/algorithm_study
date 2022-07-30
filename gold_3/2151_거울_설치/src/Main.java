import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int[] dy = {0, 1, 0, -1};
    static int[] dx = {1, 0, -1, 0};

    static char[][] map;
    static boolean[][] visited;
    static Queue<Pos> q = new LinkedList<>();
    static List<Pos> door = new ArrayList<>(2);

    static int n;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        map = new char[n][n];
        visited = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            char[] row = br.readLine().toCharArray();
            for (int j = 0; j < n; j++) {
                map[i][j] = row[j];
                if (map[i][j] == '#') {
                    door.add(new Pos(i, j, 0));
                }
            }
        }

        q.add(door.get(0));
        while (!q.isEmpty()) {
            Pos cur = q.poll();

            for (int i = 0; i < 4; i++) {
                int ny = cur.y;
                int nx = cur.x;

                while (true) {
                    ny += dy[i];
                    nx += dx[i];
                    if (ny < 0 || ny >= n || nx < 0 || nx >= n) break;
                    if (visited[ny][nx]) continue;
                    if (ny == door.get(1).y && nx == door.get(1).x) {
                        System.out.println(cur.cnt);
                        return;
                    } else if (map[ny][nx] == '!') {
                        if (!visited[ny][nx]) {
                            q.add(new Pos(ny, nx, cur.cnt + 1));
                        }
                    } else if (map[ny][nx] == '*') {
                        break;
                    }
                    visited[ny][nx] = true;
                }
            }
        }

    }

    static class Pos {
        int y;
        int x;
        int cnt;

        public Pos(int y, int x, int cnt) {
            this.y = y;
            this.x = x;
            this.cnt = cnt;
        }
    }
}
