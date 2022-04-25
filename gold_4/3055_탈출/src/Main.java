import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int y, x;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static char[][] map;
    static Queue<Coordinate> doochiQ = new LinkedList<>();
    static Queue<Coordinate> waterQ = new LinkedList<>();
    static int[] dy = {0, 1, 0, -1};
    static int[] dx = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        y = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());

        map = new char[y][x];

        for (int i = 0; i < y; i++) {
            st = new StringTokenizer(br.readLine());
            map[i] = st.nextToken().toCharArray();
            for (int j = 0; j < map[i].length; j++) {
                if (map[i][j] == 'S') doochiQ.add(new Coordinate(i, j));
                else if (map[i][j] == '*') waterQ.add(new Coordinate(i, j));
            }
        }

        int time = 0;

        while (!waterQ.isEmpty() || !doochiQ.isEmpty()) {
            time++;

            int size = waterQ.size();
            for (int i = 0; i < size; i++) {
                Coordinate cur = waterQ.poll();

                for (int j = 0; j < 4; j++) {
                    int ny = cur.y + dy[j];
                    int nx = cur.x + dx[j];

                    if (ny < 0 || ny >= y || nx < 0 || nx >= x) continue;
                    if (map[ny][nx] != '.') continue;

                    map[ny][nx] = '*';
                    waterQ.add(new Coordinate(ny, nx));
                }
            }

            size = doochiQ.size();
            for (int i = 0; i < size; i++) {
                Coordinate cur = doochiQ.poll();

                for (int j = 0; j < 4; j++) {
                    int ny = cur.y + dy[j];
                    int nx = cur.x + dx[j];

                    if (ny < 0 || ny >= y || nx < 0 || nx >= x) continue;
                    if (map[ny][nx] == 'X' || map[ny][nx] == '*' || map[ny][nx] == 'S') continue;

                    if (map[ny][nx] == 'D') {
                        System.out.println(time);
                        return;
                    }

                    map[ny][nx] = 'S';
                    doochiQ.add(new Coordinate(ny, nx));
                }
            }


        }

        System.out.println("KAKTUS");
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
