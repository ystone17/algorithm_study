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
    static char[] res;

    public static void main(String[] args) throws IOException {
        s = br.readLine();
        res = new char[s.length()];

        for (char c : s.toCharArray()) {
            alpha[c - 'A']++;
        }

        int resIdx = 0;
        for (int i = 0; i < alpha.length; i++) {
            if (alpha[i] == 0) continue;

            while (alpha[i] >= 2) {
                res[resIdx] = (char) (i + 'A');
                res[res.length - 1 - resIdx] = (char) (i + 'A');
                resIdx++;
                alpha[i] -= 2;
            }

            if (alpha[i] == 1) {
                if (res.length % 2 == 0 || res[res.length / 2] != 0) {
                    System.out.println("I'm Sorry Hansoo");
                    return;
                }
                res[res.length / 2] = (char) (i + 'A');
            }
        }

        System.out.println(String.valueOf(res));
    }
}
