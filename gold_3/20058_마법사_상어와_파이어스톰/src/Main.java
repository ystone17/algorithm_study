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

    static int n, levelNum;
    static int[][] iceBlocks;
    static int[] levels;
    static int[] dy = {0, 1, 0, -1};
    static int[] dx = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        read();
        simulation();
    }

    private static void read() throws IOException {
        st = new StringTokenizer(br.readLine());
        n = (int) Math.pow(2, Integer.parseInt(st.nextToken()));
        levelNum = Integer.parseInt(st.nextToken());

        iceBlocks = new int[n][n];
        levels = new int[levelNum];

        for (int y = 0; y < n; y++) {
            st = new StringTokenizer(br.readLine());
            for (int x = 0; x < n; x++) {
                iceBlocks[y][x] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < levelNum; i++) {
            levels[i] = Integer.parseInt(st.nextToken());
        }
    }

    private static void simulation() {
        for (int level : levels) {
            grid(level);
            melt();
        }
        int total = getTotal();
        int maxBlockSize = getMaxBlockSize();
        System.out.println(total);
        System.out.println(maxBlockSize);
    }

    private static void grid(int power) {
        int size = (int) Math.pow(2, power);

        for (int y = 0; y < n; y += size) {
            for (int x = 0; x < n; x += size) {
                rotate(y, x, size);
            }
        }

    }

    private static void rotate(int sy, int sx, int size) {
        Queue<Integer> q = new LinkedList<>();

        for (int y = sy; y < sy + size; y++) {
            for (int x = sx; x < sx + size; x++) {
                q.add(iceBlocks[y][x]);
            }
        }

        for (int x = sx + size - 1; x >= sx; x--) {
            for (int y = sy; y < sy + size; y++) {
                iceBlocks[y][x] = q.poll();
            }
        }
    }

    private static void melt() {
        Queue<int[]> q = new LinkedList<>();

        for (int y = 0; y < n; y++) {
            for (int x = 0; x < n; x++) {
                if (iceBlocks[y][x] == 0) {
                    continue;
                }
                int neighbor = 0;
                for (int dir = 0; dir < 4; dir++) {
                    int ny = y + dy[dir];
                    int nx = x + dx[dir];

                    if (ny < 0 || ny >= n || nx < 0 || nx >= n) {
                        continue;
                    }

                    if (iceBlocks[ny][nx] > 0) {
                        neighbor++;
                    }
                }
                if (neighbor < 3) {
                    q.add(new int[]{y, x});
                }
            }
        }

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            iceBlocks[cur[0]][cur[1]]--;
        }
    }

    private static int getTotal() {
        int total = 0;
        for (int y = 0; y < n; y++) {
            for (int x = 0; x < n; x++) {
                total += iceBlocks[y][x];
            }
        }
        return total;
    }

    private static int getMaxBlockSize() {
        int max = 0;

        int[][] visited = new int[n][n];
        Queue<int[]> q = new LinkedList<>();

        for (int y = 0; y < n; y++) {
            for (int x = 0; x < n; x++) {
                if (iceBlocks[y][x] == 0 || visited[y][x] == 1) {
                    continue;
                }
                int tempMax = 0;
                q.clear();
                q.add(new int[]{y, x});
                visited[y][x] = 1;

                while (!q.isEmpty()) {
                    int[] cur = q.poll();
                    tempMax++;

                    for (int dir = 0; dir < 4; dir++) {
                        int ny = cur[0] + dy[dir];
                        int nx = cur[1] + dx[dir];

                        if (ny < 0 || ny >= n || nx < 0 || nx >= n) {
                            continue;
                        }
                        if (visited[ny][nx] == 1 || iceBlocks[ny][nx] == 0) {
                            continue;
                        }

                        q.add(new int[]{ny, nx});
                        visited[ny][nx] = 1;
                    }
                }

                max = Math.max(max, tempMax);
            }
        }

        return max;
    }
}
