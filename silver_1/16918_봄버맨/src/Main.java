import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int height, width, time;
    static int[][] map;
    static int[] dy = {0, 1, 0, -1};
    static int[] dx = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        height = Integer.parseInt(st.nextToken());
        width = Integer.parseInt(st.nextToken());
        time = Integer.parseInt(st.nextToken());

        map = new int[height][width];
        for (int y = 0; y < height; y++) {
            char[] line = br.readLine().toCharArray();
            for (int x = 0; x < width; x++) {
                map[y][x] = line[x] == 'O' ? 0 : -1;
            }
        }

        for (int t = 2; t <= time; t++) {
            if (t % 2 == 0) {
                mine(t);
                continue;
            }

            boom(t);
        }

        printMap(map);
    }

    static void mine(int t) {
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                if (map[y][x] == -1) {
                    map[y][x] = t;
                }
            }
        }
    }

    static void boom(int t) {
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                if (map[y][x] == t - 3) {
                    map[y][x] = -1;
                    for (int i = 0; i < 4; i++) {
                        int ny = y + dy[i];
                        int nx = x + dx[i];

                        if(ny < 0 || ny >= height || nx < 0 || nx >= width) continue;
                        if(map[ny][nx] == t - 3) continue;

                        map[ny][nx] = -1;
                    }

                }
            }
        }
    }

    static void printMap(int[][] map) {
        for (int[] line : map) {
            for (int c : line) {
                System.out.printf("%c", c == -1 ? '.' : 'O');
            }
            System.out.println();
        }
    }
}
