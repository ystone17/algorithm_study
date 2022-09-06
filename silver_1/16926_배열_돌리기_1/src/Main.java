import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int n, m, r;
    static int[][] map, visited;
    static Deque<Integer> q = new LinkedList<>();

    static int[] dy = {1, 0, -1, 0};
    static int[] dx = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < r; i++) {
            rotate();
        }

        for (int[] ints : map) {
            for (int anInt : ints) {
                sb.append(anInt).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);

    }

    static void rotate() {
        visited = new int[n][m];

        int y, x, dir, ny, nx;

        int min = Math.min(n, m);
        for (int i = 0; i < min; i++) {
            if (visited[i][i] == 1) continue;
            q.clear();
            dir = 0;
            y = x = i;

            while (true) {
                visited[y][x] = 1;
                q.add(map[y][x]);
                ny = y + dy[dir];
                nx = x + dx[dir];

                if (ny < i || ny >= n - i || nx < i || nx >= m - i) {
                    dir = (dir + 1) % 4;
                    ny = y + dy[dir];
                    nx = x + dx[dir];
                }

                if (ny == i && nx == i) break;

                y = ny;
                x = nx;
            }

            q.addFirst(q.pollLast());

            dir = 0;
            y = x = i;

            while (true) {
                map[y][x] = q.poll();

                ny = y + dy[dir];
                nx = x + dx[dir];

                if (ny < i || ny >= n - i || nx < i || nx >= m - i) {
                    dir = (dir + 1) % 4;
                    ny = y + dy[dir];
                    nx = x + dx[dir];
                }

                if (ny == i && nx == i) break;

                y = ny;
                x = nx;
            }
        }
    }
}
