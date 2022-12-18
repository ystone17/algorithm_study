import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int n;
    static long[] koongDp = new long[68];

    public static void main(String[] args) throws IOException {
        koongDp[0] = 1;
        koongDp[1] = 1;
        koongDp[2] = 2;
        koongDp[3] = 4;

        for (int i = 4; i < koongDp.length; i++) {
            koongDp[i] = koongDp[i - 1] + koongDp[i - 2] + koongDp[i - 3] + koongDp[i - 4];
        }

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            sb.append(koongDp[Integer.parseInt(br.readLine())]).append("\n");
        }

        System.out.println(sb);
    }
}
