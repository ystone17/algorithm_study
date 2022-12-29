import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int n, p;
    static int[][] map;
    static int y, x, ny, nx, dir, ay, ax;
    static int[] dy = {1, 0, -1, 0};
    static int[] dx = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        p = Integer.parseInt(br.readLine());

        map = new int[n][n];
        int number = (int) Math.pow(n, 2);

        for (int i = 0; i < n * n; i++) {
            if (number == p) {
                ay = y + 1;
                ax = x + 1;
            }
            map[y][x] = number--;

            ny = y + dy[dir];
            nx = x + dx[dir];

            if (ny < 0 || ny >= n || nx < 0 || nx >= n || map[ny][nx] != 0) {
                dir = (dir + 1) % 4;
                ny = y + dy[dir];
                nx = x + dx[dir];
            }
            y = ny;
            x = nx;

        }

        for (int[] row : map) {
            for (int i : row) {
                sb.append(i).append(" ");
            }
            sb.append("\n");
        }

        sb.append(ay).append(" ").append(ax);
        System.out.println(sb);

    }
}
