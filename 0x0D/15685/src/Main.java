import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n, y, x, dir, gen;
    static int[] dy = {0, -1, 0, 1};
    static int[] dx = {1, 0, -1, 0};
    static int[][] map = new int[101][101];
    static int[] drawDir = new int[2049];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            dir = Integer.parseInt(st.nextToken());
            gen = Integer.parseInt(st.nextToken());

            map[y][x] = 1;
            int sy = y;
            int sx = x;
            int drawIdx = 1;

            drawDir[drawIdx] = dir;
            for (int genIdx = 0; genIdx <= gen; genIdx++) {
                for (int j = drawIdx / 2 + 1; j <= drawIdx; j++) {
                    int ny = sy + dy[drawDir[j]];
                    int nx = sx + dx[drawDir[j]];

                    map[ny][nx] = 1;
                    sy = ny;
                    sx = nx;
                }

                drawIdx *= 2;

                for (int j = drawIdx / 2 + 1; j <= drawIdx; j++) {
                    drawDir[j] = (drawDir[drawIdx + 1 - j] + 1) % 4;
                }


            }
        }

        int res = 0;
        for (int y = 0; y < 100; y++) {
            for (int x = 0; x < 100; x++) {
                if (map[y][x] != 1) continue;
                if (map[y][x + 1] == 1 && map[y + 1][x] == 1 && map[y + 1][x + 1] == 1) res++;
            }
        }

        System.out.println(res);

    }
}
