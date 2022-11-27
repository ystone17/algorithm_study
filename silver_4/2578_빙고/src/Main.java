import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int[][] used = new int[5][5];
    static int[][] u = new int[5][5];
    static Map<Integer, Pos> map = new HashMap<>();

    public static void main(String[] args) throws IOException {
        for (int i = 0; i < 5; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                map.put(Integer.parseInt(st.nextToken()), new Pos(i, j));
            }
        }

        for (int i = 0; i < 5; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                u[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                Pos pos = map.get(u[i][j]);
                used[pos.y][pos.x] = 1;
                int bingo = bingo();
                if (bingo >= 3) {
                    System.out.println(i * 5 + j + 1);
                    return;
                }
            }
        }

    }

    static int bingo() {
        boolean bingo = false;
        int bingoCnt = 0;

        for (int i = 0; i < 5; i++) {
            bingo = true;
            for (int j = 0; j < 5; j++) {
                if (used[i][j] == 0) {
                    bingo = false;
                    break;
                }
            }
            if (bingo) {
                bingoCnt++;
            }
        }

        for (int i = 0; i < 5; i++) {
            bingo = true;
            for (int j = 0; j < 5; j++) {
                if (used[j][i] == 0) {
                    bingo = false;
                    break;
                }
            }
            if (bingo) {
                bingoCnt++;
            }
        }

        for (int i = 0; i < 5; i++) {
            bingo = true;
            if (used[i][i] == 0) {
                bingo = false;
                break;
            }
        }
        if (bingo) {
            bingoCnt++;
        }

        for (int i = 0; i < 5; i++) {
            bingo = true;
            if (used[i][4 - i] == 0) {
                bingo = false;
                break;
            }
        }
        if (bingo) {
            bingoCnt++;
        }

        return bingoCnt;
    }

    static class Pos {
        int y;
        int x;

        public Pos(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
}
