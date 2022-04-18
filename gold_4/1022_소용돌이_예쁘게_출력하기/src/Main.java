import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int y, x, yy, xx, size;
    static int[][] map;
    static int[] dy = {0, -1, 0, 1, 0};
    static int[] dx = {1, 0, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());

        y = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        yy = Integer.parseInt(st.nextToken());
        xx = Integer.parseInt(st.nextToken());

        map = new int[yy - y + 1][xx - x + 1];

        int sy = 0;
        int sx = 0;
        int value = 1;
        set(sy, sx, value);

        for (int i = 0; i <= 5000; i++) {
            sy += dy[0];
            sx += dx[0];
            value++;
            set(sy, sx, value);

            for (int j = 0; j < 2 * (i + 1) - 1; j++) {
                sy += dy[1];
                sx += dx[1];
                value++;
                set(sy, sx, value);
            }

            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < 2 * (i + 1); k++) {
                    sy += dy[j + 2];
                    sx += dx[j + 2];
                    value++;
                    set(sy, sx, value);
                }
            }

        }

        for (int[] ints : map) {
            for (int anInt : ints) {
                for (int i = 0; i < size - Math.log10(anInt); i++) {
                    sb.append(" ");
                }
                sb.append(anInt).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    static void set(int sy, int sx, int v) {
        if (y <= sy && sy <= yy && x <= sx && sx <= xx) {
            map[sy - y][sx - x] = v;
            size = Math.max(size, (int) Math.log10(v));
        }
    }

}
