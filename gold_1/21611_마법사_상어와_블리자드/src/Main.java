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

    static int n, m;
    static int[][] map, dir;
    static Queue<Integer> q = new LinkedList<>();

    static int[] dy = {0, 1, 0, -1, 0};
    static int[] dx = {-1, 0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        read();
        extractQueue();

        while (m-- > 0) {
            st = new StringTokenizer(br.readLine());
            simulation(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
    }

    private static void read() throws IOException {
        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        dir = new int[n + 1][6];
        int base = 0;
        int plus = 0;
        for (int i = 3; i <= n; i++) {
            base++;
            plus += 2;
            for (int j = 1; j <= 4; j++) {
                dir[i][j] = base;
                base += plus;
            }
        }

        map = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }

    private static void extractQueue() {
        q.add(0);
        int y = n / 2;
        int x = n / 2;
        int d;
        for (int i = 1; i <= n / 2; i++) {
            d = 0;
            y += dy[d];
            x += dx[d];
            while (Math.abs(y - n / 2) <= i && Math.abs(x - n / 2) <= i) {
                q.add(map[y][x]);
                y += dy[d];
                x += dx[d];
            }

            y -= dy[d];
            x -= dx[d];
            d++;
            y += dy[d];
            x += dx[d];

            while (Math.abs(y - n / 2) <= i && Math.abs(x - n / 2) <= i) {
                q.add(map[y][x]);
                y += dy[d];
                x += dx[d];
            }
            y -= dy[d];
            x -= dx[d];
            d++;
            y += dy[d];
            x += dx[d];
            while (Math.abs(y - n / 2) <= i && Math.abs(x - n / 2) <= i) {
                q.add(map[y][x]);
                y += dy[d];
                x += dx[d];
            }
            y -= dy[d];
            x -= dx[d];
            d++;
            y += dy[d];
            x += dx[d];
            while (Math.abs(y - n / 2) <= i && Math.abs(x - n / 2) <= i) {
                q.add(map[y][x]);
                y += dy[d];
                x += dx[d];
            }
            y -= dy[d];
            x -= dx[d];
            d++;
            y += dy[d];
            x += dx[d];
            while (Math.abs(y - n / 2) <= i && Math.abs(x - n / 2) <= i) {
                q.add(map[y][x]);
                y += dy[d];
                x += dx[d];
            }
            y -= dy[d];
            x -= dx[d];
            d = 0;
            y += dy[d];
            x += dx[d];
        }
    }

    static void simulation(int d, int s) {
        d = convertD(d);
        blizzard(d, s);

    }

    private static void blizzard(int d, int s) {
        int si = 1;
        for (int i = 0; i < q.size(); i++) {
            if (si > s) {
                break;
            }
            if (i == dir[d][si]) {
                q.poll();
                si++;
                continue;
            }

            q.add(q.poll());
        }

        init();
    }

    private static void init() {
        while (q.peek() != 0) {
            q.add(q.poll());
        }
    }

    private static int convertD(int d) {
        switch (d) {
            case 1:
                return 4;
            case 3:
                return 1;
            case 4:
                return 3;
            default:
                return 2;
        }
    }
}
