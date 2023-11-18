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

    static int n, m, res;
    static char[][] map, visited;

    static int[] dy = {0, 1, 0, -1};
    static int[] dx = {1, 0, -1, 0};
    static Queue<Pos> q = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new char[n][m];
        visited = new char[n][m];

        for (int i = 0; i < n; i++) {
            map[i] = br.readLine().toCharArray();
        }

        for (int y = 0; y < n; y++) {
            for (int x = 0; x < m; x++) {
                if (map[y][x] == 'I') {
                    q.add(new Pos(y, x));
                    visited[y][x] = 1;

                    while (!q.isEmpty()) {
                        Pos cur = q.poll();


                        for (int dir = 0; dir < 4; dir++) {
                            int ny = cur.y + dy[dir];
                            int nx = cur.x + dx[dir];

                            if (ny < 0 || ny >= n || nx < 0 || nx >= m) {
                                continue;
                            }

                            if (visited[ny][nx] == 1) {
                                continue;
                            }

                            if (map[ny][nx] == 'X') {
                                continue;
                            }

                            if (map[ny][nx] == 'P') {
                                res++;
                            }

                            q.add(new Pos(ny, nx));
                            visited[ny][nx] = 1;
                        }

                    }

                    System.out.println(res == 0 ? "TT" : res);
                    return;
                }
            }
        }

    }

    static class Pos {
        int y;
        int x;

        public Pos(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
}
