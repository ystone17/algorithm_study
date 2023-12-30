import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;

    private static int n, m, dir, dist;
    private static int[][] map, clouds;

    private static int[] dy = {-99, 0, -1, -1, -1, 0, 1, 1, 1};
    private static int[] dx = {-99, -1, -1, 0, 1, 1, 1, 0, -1};
    private static int[] diagonal = {2, 4, 6, 8};

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][n];
        for (int y = 0; y < n; y++) {
            st = new StringTokenizer(br.readLine());
            for (int x = 0; x < n; x++) {
                map[y][x] = Integer.parseInt(st.nextToken());
            }
        }

        clouds = new int[n][n];
        clouds[n - 1][0] = 1;
        clouds[n - 1][1] = 1;
        clouds[n - 2][0] = 1;
        clouds[n - 2][1] = 1;

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            dir = Integer.parseInt(st.nextToken());
            dist = Integer.parseInt(st.nextToken());

            doIt(dir, dist);
        }

        System.out.println(total());
    }

    private static void doIt(int dir, int dist) {
        moveAndRain(dir, dist);
        waterCopy();
        generateCloud();
    }

    private static void moveAndRain(int dir, int dist) {
        var tempCloud = new int[n][n];

        for (int y = 0; y < n; y++) {
            for (int x = 0; x < n; x++) {
                if (clouds[y][x] == 1) {
                    var ny = (y + dy[dir] * dist + n * 100) % n;
                    var nx = (x + dx[dir] * dist + n * 100) % n;
                    tempCloud[ny][nx] = 1;

                    rain(ny, nx);
                }
            }
        }

        clouds = tempCloud;
    }

    private static void waterCopy() {
        for (int y = 0; y < n; y++) {
            for (int x = 0; x < n; x++) {
                if (clouds[y][x] == 1) {
                    for (int dir : diagonal) {
                        int ny = y + dy[dir];
                        int nx = x + dx[dir];

                        if (ny < 0 || ny >= n || nx < 0 || nx >= n) {
                            continue;
                        }

                        if (map[ny][nx] >= 1) {
                            map[y][x]++;
                        }
                    }
                }
            }
        }
    }

    private static void rain(int y, int x) {
        map[y][x]++;
    }

    private static void generateCloud() {
        for (int y = 0; y < n; y++) {
            for (int x = 0; x < n; x++) {
                if (clouds[y][x] == 1) {
                    clouds[y][x] = 0;
                    continue;
                }

                if (map[y][x] >= 2) {
                    map[y][x] -= 2;
                    clouds[y][x] = 1;
                }
            }
        }
    }

    private static int total() {
        int total = 0;
        for (int[] row : map) {
            for (int water : row) {
                total += water;
            }
        }

        return total;
    }
}
