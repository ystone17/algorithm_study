import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int paperNum, res;
    static int[][] map = new int[101][101];
    static int[] dy = {0, 1, 0, -1};
    static int[] dx = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        paperNum = Integer.parseInt(br.readLine());

        for (int i = 0; i < paperNum; i++) {
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            for (int ny = y; ny < y + 10; ny++) {
                for (int nx = x; nx < x + 10; nx++) {
                    map[ny][nx] = 1;
                }
            }
        }

        for (int y = 0; y < map.length; y++) {
            for (int x = 0; x < map.length; x++) {
                if (map[y][x] == 0) continue;

                for (int i = 0; i < 4; i++) {
                    int ny = y + dy[i];
                    int nx = x + dx[i];

                    if (ny < 0 || ny >= map.length || nx < 0 || nx >= map.length) continue;
                    if (map[ny][nx] == 1) continue;
                    res++;
                }
            }
        }

        System.out.println(res);
    }
}
