import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int size = Integer.parseInt(st.nextToken());
        int colorMax = Integer.parseInt(st.nextToken());

        Integer[][] map = new Integer[size][size];
        for (int i = 0; i < size; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < size; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        Game game = new Game(map, colorMax);

        while (game.removeBlockGroup()) {
            game.gravity();
            game.rotate();
            game.gravity();
        }

        System.out.println(game.result);
    }

    static class Game {
        Integer[][] map;
        int colorMax;
        int result;
        Queue<Integer> q = new LinkedList<>();
        int[][] visited;
        int[] dy = {0, 1, 0, -1};
        int[] dx = {1, 0, -1, 0};

        public Game(Integer[][] map, int colorMax) {
            this.map = map;
            this.colorMax = colorMax;
        }

        public boolean removeBlockGroup() {
            visited = new int[map.length][map.length];

            int total = 0;
            int rainbow = 0;
            int by = -1;
            int bx = -1;

            for (int y = 0; y < map.length; y++) {
                for (int x = 0; x < map.length; x++) {
                    if (visited[y][x] != 0) continue;
                    if (map[y][x] == null || map[y][x] == -1 || map[y][x] == 0) continue;
                    q.clear();
                    q.add(y * map.length + x);

                    visited[y][x] = map[y][x];
                    int t = 1;
                    int r = map[y][x] == 0 ? 1 : 0;

                    while (!q.isEmpty()) {
                        Integer now = q.poll();
                        int cy = now / map.length;
                        int cx = now % map.length;

                        for (int i = 0; i < 4; i++) {
                            int ny = cy + dy[i];
                            int nx = cx + dx[i];

                            if (ny < 0 || ny >= map.length || nx < 0 || nx >= map.length) continue;
                            if (visited[ny][nx] == map[y][x]) continue;
                            if (map[ny][nx] == null || map[ny][nx] == -1) continue;
                            if (map[ny][nx] != 0 && map[ny][nx] != map[y][x]) continue;

                            visited[ny][nx] = map[y][x];
                            t++;
                            r += map[ny][nx] == 0 ? 1 : 0;

                            q.add(ny * map.length + nx);
                        }
                    }

                    if (t > total) {
                        total = t;
                        rainbow = r;
                        by = y;
                        bx = x;
                        continue;
                    }

                    if (t == total && r > rainbow) {
                        total = t;
                        rainbow = r;
                        by = y;
                        bx = x;
                        continue;
                    }

                    if (t == total && r == rainbow) {
                        by = y;
                        bx = x;
                    }
                }
            }

            if (total < 2) return false;

            visited = new int[map.length][map.length];
            q.clear();

            q.add(by * map.length + bx);

            int color = map[by][bx];
            visited[by][bx] = color;
            int score = 0;

            while (!q.isEmpty()) {
                Integer now = q.poll();
                int cy = now / map.length;
                int cx = now % map.length;

                map[cy][cx] = null;
                score++;

                for (int i = 0; i < 4; i++) {
                    int ny = cy + dy[i];
                    int nx = cx + dx[i];

                    if (ny < 0 || ny >= map.length || nx < 0 || nx >= map.length) continue;
                    if (visited[ny][nx] == color) continue;
                    if (map[ny][nx] == null || map[ny][nx] == -1) continue;
                    if (map[ny][nx] != 0 && map[ny][nx] != color) continue;

                    visited[ny][nx] = color;

                    q.add(ny * map.length + nx);
                }
            }

            result += (int) Math.pow(score, 2);

            return true;
        }


        public void gravity() {
            for (int x = 0; x < map.length; x++) {
                gravityColumn(x);
            }
        }

        public void gravityColumn(int x) {
            int bottom = map.length - 1;

            for (int y = map.length - 2; y >= 0; y--) {
                if (map[y][x] == null || map[y][x] == -1) continue;
                for (int i = y + 1; i < map.length; i++) {
                    if (map[i][x] == null) {
                        bottom = i;
                        continue;
                    }

                    bottom = i - 1;
                    break;
                }

                if (y == bottom) continue;
                map[bottom][x] = map[y][x];
                map[y][x] = null;
            }

        }

        public void rotate() {
            q.clear();
            for (Integer[] ints : map) {
                for (int x = 0; x < map.length; x++) {
                    q.add(ints[x]);
                }
            }

            for (int x = 0; x < map.length; x++) {
                for (int y = map.length - 1; y >= 0; y--) {
                    map[y][x] = q.poll();
                }
            }
        }
    }
}
