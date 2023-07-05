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
            if (check(sign)) {
                sb.append("YES").append("\n");
            } else {
                sb.append("NO").append("\n");
            }
        }

        System.out.println(sb);
    }

    private static boolean check(char[] sign) {
        for (int i = sign.length - 1; i >= 0; ) {
            boolean typeZeroOne = isTypeZeroOne(sign, i);
            if (typeZeroOne) {
                i -= 2;
                continue;
            }

            int idx = isTypeMulti(sign, i);
            if (idx == -1) {
                return false;
            }

            i = idx;
        }

        return true;
    }

    private static int isTypeMulti(char[] sign, int endIdx) {
        if (endIdx < 3) {
            return -1;
        }

        int idx = endIdx;

        while (idx >= 0 && sign[idx] == '1') {
            idx--;
        }

        if (idx <= 1) {
            return -1;
        }

        while (idx >= 0 && sign[idx] == '0') {
            idx--;
        }

        if (idx < 0) {
            return -1;
        }

        return idx - 1;
    }

    private static boolean isTypeZeroOne(char[] sign, int endIdx) {
        if (endIdx <= 0) {
            return false;
        }

        if (sign[endIdx - 1] != '0' || sign[endIdx] != '1') {
            return false;
        }

        return sign[endIdx - 2] != '0';
    }
}
