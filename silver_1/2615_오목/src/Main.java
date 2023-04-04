import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int[][] map = new int[20][20];

    public static void main(String[] args) throws IOException {
        for (int i = 0; i < 19; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 19; j++) {
                map[i + 1][j + 1] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 1; i < 20; i++) {
            for (int j = 1; j < 20; j++) {
                if (map[i][j] == 0) continue;
                if (isOk(i, j)) {
                    sb.append(map[i][j]).append("\n").append(i).append(" ").append(j);
                    System.out.println(sb);
                    return;
                }
            }
        }

        System.out.println(0);
    }

    static boolean isOk(int y, int x) {
        if (vertical(y, x)) {
            return true;
        }

        if (horizon(y, x)) {
            return true;
        }

        if (underCross(y, x)) {
            return true;
        }

        if (upperCross(y, x)) {
            return true;
        }

        return false;
    }

    static boolean vertical(int y, int x) {
        if (map[y][x] == map[y - 1][x]) {
            return false;
        }

        for (int i = 1; i <= 4; i++) {
            int ny = y + i;
            if (ny >= 20) return false;

            if (map[y][x] != map[ny][x]) {
                return false;
            }
        }

        if (y + 5 < 20) {
            return map[y][x] != map[y + 5][x];
        }

        return true;
    }

    static boolean horizon(int y, int x) {
        if (map[y][x] == map[y][x - 1]) {
            return false;
        }

        for (int i = 1; i <= 4; i++) {
            int nx = x + i;
            if (nx >= 20) return false;

            if (map[y][x] != map[y][nx]) {
                return false;
            }
        }

        if (x + 5 < 20) {
            return map[y][x] != map[y][x + 5];
        }

        return true;
    }

    static boolean underCross(int y, int x) {
        if (map[y][x] == map[y - 1][x - 1]) {
            return false;
        }

        for (int i = 1; i <= 4; i++) {
            int ny = y + i;
            int nx = x + i;
            if (ny >= 20) return false;
            if (nx >= 20) return false;

            if (map[y][x] != map[ny][nx]) {
                return false;
            }
        }

        if (x + 5 < 20 && y + 5 < 20) {
            return map[y][x] != map[y + 5][x + 5];
        }

        return true;
    }

    static boolean upperCross(int y, int x) {
        if (y + 1 < 20 && map[y][x] == map[y + 1][x - 1]) {
            return false;
        }

        for (int i = 1; i <= 4; i++) {
            int ny = y - i;
            int nx = x + i;
            if (ny < 0) return false;
            if (nx >= 20) return false;

            if (map[y][x] != map[ny][nx]) {
                return false;
            }
        }

        if (x + 5 < 20 && y - 5 >= 0) {
            return map[y][x] != map[y - 5][x + 5];
        }

        return true;
    }

}
