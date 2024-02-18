import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
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
        for (char[] row : copyMap) {
            Arrays.fill(row, '.');
        }

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

        var minY = 1000;
        var minX = 1000;
        var maxY = -1;
        var maxX = -1;

        for (int y = 0; y < yLen; y++) {
            for (int x = 0; x < xLen; x++) {
                if (copyMap[y][x] == 'X') {
                    minY = Math.min(minY, y);
                    minX = Math.min(minX, x);
                    maxY = Math.max(maxY, y);
                    maxX = Math.max(maxX, x);
                }
            }
        }

        for (int y = minY; y <= maxY; y++) {
            for (int x = minX; x <= maxX; x++) {
                sb.append(copyMap[y][x]);
            }
            sb.append("\n" );
        }

        System.out.println(sb);
    }
}
