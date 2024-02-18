import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int yLen, xLen;

    static int[] dy = {0, 1, 0, -1};
    static int[] dx = {1, 0, -1, 0};

    static char[][] map, copyMap;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());

        yLen = Integer.parseInt(st.nextToken());
        xLen = Integer.parseInt(st.nextToken());

        map = new char[yLen][xLen];
        for (int y = 0; y < yLen; y++) {
            map[y] = br.readLine().toCharArray();
        }

        copyMap = new char[yLen][xLen];

        for (int y = 0; y < yLen; y++) {
            for (int x = 0; x < xLen; x++) {
                if (map[y][x] == '.') {
                    continue;
                }

                int count = 0;

                for (int dir = 0; dir < 4; dir++) {
                    int ny = y + dy[dir];
                    int nx = x + dx[dir];

                    if (ny < 0 || ny >= yLen || nx < 0 || nx >= xLen || map[ny][nx] == '.') {
                        count++;
                    }
                }

                if (count >= 3) {
                    continue;
                }

                copyMap[y][x] = 'X';
            }
        }

        var y1 = -1;
        var x1 = -1;
        var y2 = -1;
        var x2 = -1;

        for (int x = 0; x < xLen; x++) {
            for (int y = 0; y < yLen; y++) {
                if (copyMap[y][x] == 'X') {
                    y1 = y;
                    x1 = x;
                    break;
                }
            }
            if (y1 != -1) {
                break;
            }
        }

        for (int x = xLen - 1; x >= 0; x--) {
            for (int y = yLen - 1; y >= 0; y--) {
                if (copyMap[y][x] == 'X') {
                    y2 = y;
                    x2 = x;
                    break;
                }
            }
            if (y2 != -1) {
                break;
            }
        }

        for (int y = y1; y <= y2; y++) {
            for (int x = x1; x <= x2; x++) {
                sb.append(copyMap[y][x]);
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}
