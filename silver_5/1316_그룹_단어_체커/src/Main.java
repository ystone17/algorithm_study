import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int n;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());


        int res = 0;
        for (int i = 0; i < n; i++) {
            res += check(br.readLine());
        }

        System.out.println(res);
    }

    static int check(String s) {
        boolean[] alpha = new boolean[26];
        char before = s.charAt(0);
        alpha[before - 'a'] = true;

        for (char c : s.toCharArray()) {
            if (before == c) continue;

            if (alpha[c - 'a']) {
                return 0;
            }

            before = c;
            alpha[c - 'a'] = true;
        }

        return 1;
    }
}