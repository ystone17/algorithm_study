import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static Queue<Pos> q = new LinkedList<>();
    static boolean[][] visited;

    static int[] dy = {0, 1, 0, -1};
    static int[] dx = {1, 0, -1, 0};
    static int[][] map;
    static int yLen, xLen, count;

    public static void main(String[] args) throws IOException {
        Dice dice = new Dice();

        st = new StringTokenizer(br.readLine());
        yLen = Integer.parseInt(st.nextToken());
        xLen = Integer.parseInt(st.nextToken());
        count = Integer.parseInt(st.nextToken());

        map = new int[yLen][xLen];
        for (int y = 0; y < yLen; y++) {
            st = new StringTokenizer(br.readLine());
            for (int x = 0; x < xLen; x++) {
                map[y][x] = Integer.parseInt(st.nextToken());
            }
        }

        int dir = 0;
        int y = 0;
        int x = 0;
        int ny = 0;
        int nx = 0;
        int a = 0;
        int b = 0;
        int c = 0;
        int point = 0;

        while (count-- > 0) {
            ny = y + dy[dir];
            nx = x + dx[dir];

            if (ny < 0 || ny >= yLen || nx < 0 || nx >= xLen) {
                dir = (dir + 2) % 4;
                ny = y + dy[dir];
                nx = x + dx[dir];
            }

            dice.rotateDice(dir);
            a = dice.getBottomNum();

            y = ny;
            x = nx;

            b = map[y][x];
            c = bfs(y, x);

            point += b * c;

            if (a > b) {
                dir = (dir + 1) % 4;
            } else if (a < b) {
                dir = (dir + 3) % 4;
            }
        }

        System.out.println(point);
    }

    static int bfs(int y, int x) {
        q.clear();
        visited = new boolean[yLen][xLen];
        int num = map[y][x];
        int res = 0;
        q.add(new Pos(y, x));
        visited[y][x] = true;

        while (!q.isEmpty()) {
            Pos cur = q.poll();
            res++;

            for (int i = 0; i < 4; i++) {
                int ny = cur.y + dy[i];
                int nx = cur.x + dx[i];

                if (ny < 0 || ny >= yLen || nx < 0 || nx >= xLen) continue;
                if (visited[ny][nx]) continue;
                if (map[ny][nx] != num) continue;

                visited[ny][nx] = true;
                q.add(new Pos(ny, nx));
            }
        }

        return res;
    }

    static class Dice {
        private final int[][] dice = {
                {0, 2},
                {4, 1, 3},
                {0, 5},
                {0, 6}
        };

        private final Deque<Integer> q = new LinkedList<>();

        private final int[][][] pos = {
                {
                        {1, 0},
                        {1, 1},
                        {1, 2},
                        {3, 1}
                },
                {
                        {0, 1},
                        {1, 1},
                        {2, 1},
                        {3, 1}
                }

        };

        void rotateDice(int dir) {
            q.clear();

            if (dir % 2 == 0) {
                for (int[] p : pos[0]) {
                    q.add(dice[p[0]][p[1]]);
                }
            } else {
                for (int[] p : pos[1]) {
                    q.add(dice[p[0]][p[1]]);
                }
            }

            if (dir < 2) {
                q.addFirst(q.pollLast());
            } else {
                q.addLast(q.pollFirst());
            }

            if (dir % 2 == 0) {
                for (int[] p : pos[0]) {
                    dice[p[0]][p[1]] = q.pollFirst();
                }
            } else {
                for (int[] p : pos[1]) {
                    dice[p[0]][p[1]] = q.pollFirst();
                }
            }
        }

        int getBottomNum() {
            return dice[3][1];
        }

        void print() {
            for (int[] die : dice) {
                System.out.println(Arrays.toString(die));
            }
            System.out.println();
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
