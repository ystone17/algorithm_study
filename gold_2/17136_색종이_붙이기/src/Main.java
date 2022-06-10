import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static char[][] paper = new char[10][10];
    static int[] remainder = {0, 5, 5, 5, 5, 5};
    static boolean[][] visited = new boolean[10][10];
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        for (int i = 0; i < 10; i++) {
            char[] chars = br.readLine().toCharArray();
            for (int j = 0; j < chars.length; j += 2) {
                paper[i][j / 2] = chars[j];
            }
        }

        solve(0, 0, 0);
        if (answer == Integer.MAX_VALUE) System.out.println(-1);
        else System.out.println(answer);
    }

    static void solve(int y, int x, int count) {
        if (y > 9) {
            answer = Math.min(answer, count);
            return;
        }

        if (answer <= count) return;

        if (x > 9) {
            solve(y + 1, 0, count);
            return;
        }

        if (paper[y][x] == '1') {
            for (int len = 5; len > 0; len--) {
                if (remainder[len] > 0 && check(y, x, len)) {
                    fill(y, x, len, '0');
                    remainder[len]--;
                    solve(y, x + 1, count + 1);
                    remainder[len]++;
                    fill(y, x, len, '1');
                }
            }
        } else {
            solve(y, x + 1, count);
        }
    }

    static boolean check(int y, int x, int len) {
        for (int i = y; i < y + len; i++) {
            for (int j = x; j < x + len; j++) {
                if (i >= 10 || j >= 10) return false;
                if (paper[i][j] == '0') return false;
            }
        }
        return true;
    }

    static void fill(int y, int x, int len, char c) {
        for (int i = y; i < y + len; i++) {
            for (int j = x; j < x + len; j++) {
                paper[i][j] = c;
            }
        }
    }
}
