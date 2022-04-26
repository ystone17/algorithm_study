import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int y, x, time, cleanY1, cleanY2, cleanX, answer;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int[][] map, copy;
    static Queue<Coordinate> q = new LinkedList<>();
    static int[] dy = {0, 1, 0, -1};
    static int[] dx = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        y = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        time = Integer.parseInt(st.nextToken());

        map = new int[y][x];
        for (int i = 0; i < y; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < x; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] > 0) q.add(new Coordinate(i, j));
                else if (map[i][j] == -1) cleanY2 = i;
            }
        }
        cleanY1 = cleanY2 - 1;

        while (time-- > 0) {
            copy = new int[y][x];
            copy[cleanY1][cleanX] = -1;
            copy[cleanY2][cleanX] = -1;

            int size = q.size();
            for (int z = 0; z < size; z++) {
                Coordinate cur = q.poll();

                int p = map[cur.y][cur.x] / 5;
                int b = map[cur.y][cur.x];

                if (p != 0) {
                    for (int i = 0; i < 4; i++) {
                        int ny = cur.y + dy[i];
                        int nx = cur.x + dx[i];

                        if (ny < 0 || ny >= y || nx < 0 || nx >= x || map[ny][nx] == -1) continue;
                        copy[ny][nx] += p;
                        b -= p;
                    }
                }

                if (b != 0) {
                    copy[cur.y][cur.x] += b;
                }
            }

            map = copy;
            move();
            for (int i = 0; i < y; i++) {
                for (int j = 0; j < x; j++) {
                    if(map[i][j] > 0){
                        q.add(new Coordinate(i, j));
                    }
                }
            }
        }

        for (int[] ints : map) {
            for (int anInt : ints) {
                answer += anInt;
            }
        }

        System.out.println(answer + 2);
    }

    static void move() {
        for (int i = cleanY1 - 2; i >= 0; i--) {
            map[i + 1][0] = map[i][0];
        }
        for (int i = 1; i < x; i++) {
            map[0][i - 1] = map[0][i];
        }
        for (int i = 1; i <= cleanY1; i++) {
            map[i - 1][x - 1] = map[i][x - 1];
        }
        for (int i = x - 1; i > 1; i--) {
            map[cleanY1][i] = map[cleanY1][i - 1];
        }
        map[cleanY1][1] = 0;

        for (int i = cleanY2 + 2; i < y; i++) {
            map[i - 1][0] = map[i][0];
        }
        for (int i = 1; i < x; i++) {
            map[y - 1][i - 1] = map[y - 1][i];
        }
        for (int i = y - 2; i >= cleanY2; i--) {
            map[i + 1][x - 1] = map[i][x - 1];
        }
        for (int i = x - 1; i > 1; i--) {
            map[cleanY2][i] = map[cleanY2][i - 1];
        }
        map[cleanY2][1] = 0;
    }

    static class Coordinate {
        int y;
        int x;

        public Coordinate(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
}
