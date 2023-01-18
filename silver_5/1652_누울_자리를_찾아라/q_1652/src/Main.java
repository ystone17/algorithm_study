import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static int n;
    static char[][] map;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());

        map = new char[n][n];
        for (int i = 0; i < n; i++) {
            map[i] = br.readLine().toCharArray();
        }

        int hor = 0;
        int ver = 0;

        for (int i = 0; i < n; i++) {
            int cnt = 0;
            for (int x = 0; x < n; x++) {
                if (map[i][x] == '.') {
                    cnt++;
                }

                if (map[i][x] == 'X') {
                    if (cnt >= 2) hor++;
                    cnt = 0;
                }
            }
            if (cnt >= 2) hor++;
        }

        for (int i = 0; i < n; i++) {
            int cnt = 0;
            for (int y = 0; y < n; y++) {
                if (map[y][i] == '.') {
                    cnt++;
                }

                if (map[y][i] == 'X') {
                    if (cnt >= 2) ver++;
                    cnt = 0;
                }
            }
            if (cnt >= 2) ver++;
        }

        System.out.printf("%d %d", hor, ver);
    }
}
