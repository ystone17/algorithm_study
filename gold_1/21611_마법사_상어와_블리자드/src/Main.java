import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int n, m;
    static int[][] map, dir;
    static Deque<Integer> q = new LinkedList<>();

    static int[] dy = {0, 1, 0, -1, 0};
    static int[] dx = {-1, 0, 1, 0, -1};
    static int[] res = new int[4];

    public static void main(String[] args) throws IOException {
        read();
        extractQueue();

        while (m-- > 0) {
            st = new StringTokenizer(br.readLine());
            simulation(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        System.out.println(res[1] + res[2] * 2 + res[3] * 3);
    }

    private static void read() throws IOException {
        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        dir = new int[n + 1][6];
        int base = 0;
        int plus = 0;
        for (int i = 1; i <= n; i++) {
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
        q.add(-1);
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
        }

        while (q.peekLast() == 0) {
            q.pollLast();
        }
    }

    static void simulation(int d, int s) {
        d = convertD(d);
        blizzard(d, s);
        while (true) {
            if (!bomb()) {
                break;
            }
        }
        change();
    }

    private static void blizzard(int d, int s) {
        int si = 1;
        for (int i = 0; i < q.size(); i++) {
            if (si > s) {
                break;
            }
            if (i == dir[si][d]) {
                q.poll();
                si++;
                continue;
            }

            q.add(q.poll());
        }

        init();
    }

    private static void init() {
        while (q.peek() != -1) {
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

    private static boolean bomb() {
        int number = 0;
        int count = 0;
        boolean boom = false;

        int size = q.size();
        while (size-- > 0) {
            if (q.peek() == number) {
                count++;
            } else {
                if (count >= 4) {
                    for (int i = 0; i < count; i++) {
                        q.pollLast();
                    }
                    res[number] += count;
                    boom = true;
                }
                number = q.peek();
                count = 1;
            }

            q.add(q.poll());
        }

        if (count >= 4) {
            for (int i = 0; i < count; i++) {
                q.pollLast();
            }
            res[number] += count;
            boom = true;
        }

        return boom;
    }

    private static void change() {
        q.poll();
        if (q.isEmpty()) {
            q.add(-1);
            return;
        }
        q.addLast(100);
        int number = q.peek();
        int count = 0;
        int size = q.size();

        while (size-- > 0) {
            if (number == q.peek()) {
                count++;
            } else {
                q.add(count);
                q.add(number);

                number = q.peek();
                count = 1;
            }

            q.poll();
        }
        q.addFirst(-1);

        size = q.size() - n * n;
        while (size-- > 0) {
            q.pollLast();
        }
    }
}
