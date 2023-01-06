import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int[][] partSum;
    static char[] chars;
    static int n;
    static int c, start, end;

    public static void main(String[] args) throws IOException {
        init();
        solve();
    }

    private static void solve() throws IOException {
        n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            c = st.nextToken().charAt(0) - 'a';
            start = Integer.parseInt(st.nextToken());
            end = Integer.parseInt(st.nextToken());

            sb.append(partSum[c][end + 1] - partSum[c][start]).append("\n");
        }
        System.out.println(sb);
    }

    private static void init() throws IOException {
        chars = br.readLine().toCharArray();
        partSum = new int[26][chars.length + 1];

        for (int c = 0; c < chars.length; c++) {
            for (int alpha = 0; alpha < 26; alpha++) {
                partSum[alpha][c + 1] = partSum[alpha][c];
                if (alpha == chars[c] - 'a') {
                    partSum[alpha][c + 1]++;
                }
            }
        }
    }
}
