import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int y, x;
    static char[][] map;
    static int[] dy = new int[]{0, 1, 0, -1};
    static int[] dx = new int[]{1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());

        y = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());

        map = new char[y][x];

        for (int i = 0; i < y; i++) {
            map[i] = br.readLine().toCharArray();
        }

        for (int i = 0; i < y; i++) {
            for (int j = 0; j < x; j++) {
                if (map[i][j] == '.') {
                    map[i][j] = 'D';
                }
            }
        }

        if (check()) {
            System.out.println(1);
            for (char[] row : map) {
                for (char r : row) {
                    System.out.printf("%c", r);
                }
                System.out.println();
            }
        } else {
            System.out.println(0);
        }
    }

    static boolean check() {
        for (int i = 0; i < y; i++) {
            for (int j = 0; j < x; j++) {
                if (map[i][j] == 'W') {
                    for (int dir = 0; dir < 4; dir++) {
                        int ny = i + dy[dir];
                        int nx = j + dx[dir];

                        if (ny < 0 || ny >= y || nx < 0 || nx >= x) {
                            continue;
                        }

                        if (map[ny][nx] == 'S') {
                            return false;
                        }
                    }
                }
            }
        }

        return true;
    }
}
