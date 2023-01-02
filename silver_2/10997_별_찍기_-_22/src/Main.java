import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int n;
    static char[][] map;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        if(n == 1) {
            System.out.println("*");
            return;
        }

        map = new char[n * 4 - 1][(n - 1) * 4 + 1];

        draw(n, 0, 0);
        print();
    }

    private static void draw(int level, int y, int x) {
        if (level == 1) {
            for (int i = 0; i < 3; i++) {
                map[y + i][x] = '*';
            }
            return;
        }

        int yLen = level * 4 - 1;
        int xLen = (level - 1) * 4 + 1;

        for (int i = 0; i < yLen; i++) {
            map[y + i][x] = '*';
            if (i >= 2)
                map[y + i][x + xLen - 1] = '*';
        }

        map[y + 2][x + xLen - 2] = '*';

        for (int i = 0; i < xLen; i++) {
            map[y][x + i] = map[y + yLen - 1][x + i] = '*';
        }

        draw(level - 1, y + 2, x + 2);
    }


    private static void print() {
        for (int i = 0; i < map.length; i++) {
            if(i == 1) {
                sb.append("*").append("\n");
                continue;
            }
            char[] row = map[i];
            for (char c : row) {
                sb.append(c == '*' ? c : ' ');
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
