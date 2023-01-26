import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int r, c, n, rl, isolatedNumber;
    static char[][] map;
    static int[][] visited;
    static int[] dy = {0, 1, 0, -1};
    static int[] dx = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        map = new char[r][c];

        for (int i = 0; i < r; i++) {
            map[i] = br.readLine().toCharArray();
        }

        n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            delete(Integer.parseInt(st.nextToken()));
            bfs();
            if (isolatedNumber != -1) move();
        }
        print();
    }

    private static void print() {
        for (char[] chars : map) {
            for (char aChar : chars) {
                System.out.printf("%c", aChar);
            }
            System.out.println();
        }
    }

    static void delete(int height) {
        if (rl % 2 == 0) {
            for (int i = 0; i < c; i++) {
                if (map[r - height][i] == 'x') {
                    map[r - height][i] = '.';
                    break;
                }
            }
        } else {
            for (int i = c - 1; i >= 0; i--) {
                if (map[r - height][i] == 'x') {
                    map[r - height][i] = '.';
                    break;
                }
            }
        }

        rl++;
    }

    static void bfs() {
        isolatedNumber = -1;
        visited = new int[r][c];
        Queue<Integer> q = new LinkedList<>();
        int ccNumber = 1;
        boolean isIsolated;

        for (int y = 0; y < r; y++) {
            for (int x = 0; x < c; x++) {
                if (map[y][x] == '.') continue;
                if (visited[y][x] != 0) continue;

                visited[y][x] = ccNumber;
                q.add(y * c + x);
                isIsolated = true;

                while (!q.isEmpty()) {
                    Integer cur = q.poll();
                    int cy = cur / c;
                    int cx = cur % c;
                    if (cy == r - 1) {
                        isIsolated = false;
                    }

                    for (int i = 0; i < 4; i++) {
                        int ny = cy + dy[i];
                        int nx = cx + dx[i];

                        if (ny < 0 || ny >= r || nx < 0 || nx >= c) continue;
                        if (visited[ny][nx] != 0) continue;
                        if (map[ny][nx] == '.') continue;

                        visited[ny][nx] = ccNumber;
                        q.add(ny * c + nx);
                    }
                }

                if (isIsolated) isolatedNumber = ccNumber;
                ccNumber++;
            }
        }
    }

    static void move() {
        int moveCnt = 123_456;

        for (int y = 0; y < r; y++) {
            for (int x = 0; x < c; x++) {
                if (visited[y][x] != isolatedNumber) continue;

                int temp = r - 1 - y;
                for (int ny = y + 1; ny < r; ny++) {
                    if (visited[ny][x] == isolatedNumber) continue;
                    if (map[ny][x] == 'x') {
                        temp = ny - 1 - y;
                        break;
                    }
                }

                moveCnt = Math.min(moveCnt, temp);
            }
        }

        if (moveCnt == 123_456) return;

        for (int y = r - 1; y >= 0; y--) {
            for (int x = c - 1; x >= 0; x--) {
                if (visited[y][x] != isolatedNumber) continue;

                map[y + moveCnt][x] = 'x';
                map[y][x] = '.';
            }
        }
    }

}
