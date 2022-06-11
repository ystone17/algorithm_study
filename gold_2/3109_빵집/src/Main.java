import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static char[][] map;
    static int yLen, xLen, answer;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        yLen = Integer.parseInt(st.nextToken());
        xLen = Integer.parseInt(st.nextToken());

        map = new char[yLen][xLen];

        for (int i = 0; i < yLen; i++) {
            map[i] = br.readLine().toCharArray();
        }

        for (int i = 0; i < yLen; i++) {
            if (check(i, 0)) answer++;
        }
        System.out.println(answer);

    }

    static boolean check(int y, int x) {
        if (x == xLen - 1) return true;

        if (map[y][x] == '-') return false;
        map[y][x] = '-';


        if (y > 0 && map[y - 1][x + 1] == '.') {
            if (check(y - 1, x + 1)) return true;
        }

        if (map[y][x + 1] == '.') {
            if (check(y, x + 1)) return true;
        }

        if (y < yLen - 1 && map[y + 1][x + 1] == '.') {
            if (check(y + 1, x + 1)) return true;
        }

        return false;
    }


}
