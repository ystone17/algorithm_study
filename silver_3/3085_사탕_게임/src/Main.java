import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int n, res;
    static char[][] map;

    static int[] dy = {0, 1};
    static int[] dx = {1, 0};

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        map = new char[n][n];

        for (int i = 0; i < n; i++) map[i] = br.readLine().toCharArray();

        for (int y = 0; y < n; y++) {
            for (int x = 0; x < n; x++) {
                res = Math.max(res, game(y, x));
            }
        }

        sb.append(res);
        System.out.println(sb);
    }

    static int game(int y, int x) {
        int ny, nx, res = 0;

        for (int i = 0; i < 2; i++) {
            ny = y + dy[i];
            nx = x + dx[i];

            if (ny == n || nx == n) continue;
            swap(y, x, ny, nx);
            res = Math.max(res, find());
            swap(ny, nx, y, x);
        }

        return res;
    }

    static void swap(int y, int x, int ny, int nx) {
        char temp = map[ny][nx];
        map[ny][nx] = map[y][x];
        map[y][x] = temp;
    }


    static int find() {
        char color;
        int cnt, max = 0;

        for (int y = 0; y < n; y++) {
            color = map[y][0];
            cnt = 1;
            for (int x = 1; x < n; x++) {
                if (map[y][x] == color) {
                    max = Integer.max(max, ++cnt);
                } else {
                    cnt = 1;
                    color = map[y][x];
                }
            }
        }

        for (int x = 0; x < n; x++) {
            color = map[0][x];
            cnt = 1;
            for (int y = 1; y < n; y++) {
                if (map[y][x] == color) {
                    max = Integer.max(max, ++cnt);
                } else {
                    cnt = 1;
                    color = map[y][x];
                }
            }
        }

        return max;
    }
}
