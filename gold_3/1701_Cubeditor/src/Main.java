import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static String s;
    static int res = 0;
    static int[] table;

    public static void main(String[] args) throws IOException {
        s = br.readLine();

        for (int i = 0; i < s.length(); i++) {
            res = Math.max(res, initTable(s.substring(i)));
        }

        System.out.println(res);
    }

    private static int initTable(String s) {
        int max = 0;

        int length = s.length();
        table = new int[length];

        int idx = 0;

        for (int i = 1; i < length; i++) {
            while (idx > 0 && s.charAt(i) != s.charAt(idx)) {
                idx = table[idx - 1];
            }

            if (s.charAt(i) == s.charAt(idx)) {
                idx++;
                table[i] = idx;
                max = Math.max(max, table[i]);
            }
        }

        return max;
    }
}
