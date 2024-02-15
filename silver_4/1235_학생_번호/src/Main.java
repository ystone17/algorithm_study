import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int n, res = 0;
    static String[] seq;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());

        seq = new String[n];
        for (int i = 0; i < n; i++) {
            seq[i] = br.readLine();
        }

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = seq[i].length() - 1; k >= 0; k--) {
                    if (seq[i].charAt(k) != seq[j].charAt(k)) {

                        res = Math.max(res, seq[i].length() - k);

                        break;
                    }
                }
            }
        }

        System.out.println(res);
    }
}
