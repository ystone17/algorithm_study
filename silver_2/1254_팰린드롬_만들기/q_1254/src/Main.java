import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static char[] chars;
    static int res = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        chars = br.readLine().toCharArray();

        for (int i = chars.length - 1; i >= 0; i--) {
            if (odd(i)) {
                res = Math.min(res, i * 2 + 1);
            }

            if (even(i)) {
                res = Math.min(res, (i + 1) * 2);
            }
        }

        System.out.println(res);

    }

    static boolean odd(int idx) {
        int cnt = chars.length - idx;
        for (int i = 0; i < cnt; i++) {
            if (idx - i < 0) return false;
            if (idx + i >= chars.length) return false;
            if (chars[idx - i] != chars[idx + i]) return false;
        }

        return true;
    }

    static boolean even(int idx) {
        int cnt = chars.length - idx - 1;
        int left = idx;
        int right = idx + 1;

        for (int i = 0; i < cnt; i++) {
            if (left < 0) return false;
            if (right >= chars.length) return false;
            if (chars[left] != chars[right]) return false;
            left--;
            right++;
        }

        return true;
    }
}
