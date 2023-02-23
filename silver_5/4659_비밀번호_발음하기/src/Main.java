import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static String s;
    static int[] alpha = new int[26];

    public static void main(String[] args) throws IOException {

        alpha['a' - 'a'] = 1;
        alpha['e' - 'a'] = 1;
        alpha['i' - 'a'] = 1;
        alpha['o' - 'a'] = 1;
        alpha['u' - 'a'] = 1;

        while (!(s = br.readLine()).equals("end")) {
            if (one()) {
                sb.append(String.format("<%s> is not acceptable.", s)).append("\n");
                continue;
            }

            if (two()) {
                sb.append(String.format("<%s> is not acceptable.", s)).append("\n");
                continue;
            }

            if (three()) {
                sb.append(String.format("<%s> is not acceptable.", s)).append("\n");
                continue;
            }

            sb.append(String.format("<%s> is acceptable.", s)).append("\n");
        }

        System.out.println(sb);
    }

    private static boolean one() {
        if (s.contains("a")) return false;
        if (s.contains("e")) return false;
        if (s.contains("i")) return false;
        if (s.contains("o")) return false;
        if (s.contains("u")) return false;

        return true;
    }

    private static boolean two() {
        int a = 0;
        int b = 0;

        for (char c : s.toCharArray()) {
            if (alpha[c - 'a'] == 1) {
                a++;
                b = 0;
            } else {
                a = 0;
                b++;
            }

            if (a >= 3 || b >= 3) {
                return true;
            }
        }

        return false;
    }

    private static boolean three() {
        int a = s.charAt(0) - 'a';

        char[] chars = s.toCharArray();
        for (int i = 1; i < chars.length; i++) {
            char c = chars[i];
            if (a == c - 'a' && (a != 'e' - 'a' && a != 'o' - 'a')) {
                return true;
            }

            a = c - 'a';
        }

        return false;
    }
}
