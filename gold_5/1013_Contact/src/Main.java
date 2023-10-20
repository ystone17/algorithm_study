import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int tc;
    static char[] sign;

    public static void main(String[] args) throws IOException {
        tc = Integer.parseInt(br.readLine());

        while (tc-- > 0) {
            sign = br.readLine().toCharArray();
            sb.append(check(sign)).append("\n");
        }

        System.out.println(sb);
    }

    public static String check(char[] sign) {
        int idx = 0;
        int res;
        while (idx < sign.length) {
            if (sign[idx] == '0') {
                if (isAType(sign, idx)) {
                    idx += 2;
                    continue;
                }
                return "NO";
            } else {
                res = getBTypeSize(sign, idx);
                if (res == -1) {
                    return "NO";
                }
                idx += res;
            }
        }

        return "YES";
    }

    private static boolean isAType(char[] sign, int idx) {
        if (idx + 1 >= sign.length) {
            return false;
        }

        return sign[idx + 1] == '1';
    }

    private static int getBTypeSize(char[] sign, int idx) {
        if (idx + 3 >= sign.length) {
            return -1;
        }

        if (sign[idx + 1] == '1') {
            return -1;
        }

        if (sign[idx + 2] == '1') {
            return -1;
        }

        int cur = idx + 3;
        while (cur < sign.length && sign[cur] == '0') {
            cur++;
        }

        while (cur < sign.length && sign[cur] == '1') {
            cur++;
        }

        if (cur >= sign.length) {
            return cur - idx;
        }

        if (cur + 1 == sign.length) {
            return -1;
        }

        if (sign[cur + 1] == '0') {
            if (sign[cur - 2] == '0') {
                return -1;
            }
            return cur - idx - 1;
        }

        return cur - idx;
    }
}
