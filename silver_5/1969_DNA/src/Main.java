import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int[] alpha = new int[26];
    static int n, m;
    static String[] seq;
    static char[] res;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        seq = new String[n];
        res = new char[m];

        for (int i = 0; i < n; i++) {
            seq[i] = br.readLine();
        }

        int sum = 0;
        for (int i = 0; i < m; i++) {
            int max = 0;
            alpha = new int[26];
            for (int j = 0; j < n; j++) {
                alpha[seq[j].charAt(i) - 'A']++;
                max = Math.max(max, alpha[seq[j].charAt(i) - 'A']);
            }

            for (int k = 0; k < alpha.length; k++) {
                if (alpha[k] == max) {
                    res[i] = (char) (k + 'A');
                    max++;
                } else {
                    sum += alpha[k];
                }
            }
        }
        System.out.println(String.valueOf(res));
        System.out.println(sum);
    }
}
