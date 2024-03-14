import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int tc, l, n;
    static int[] seq;

    public static void main(String[] args) throws IOException {
        tc = Integer.parseInt(br.readLine());

        while (tc-- > 0) {
            st = new StringTokenizer(br.readLine());
            l = Integer.parseInt(st.nextToken());
            n = Integer.parseInt(st.nextToken());

            seq = new int[n];
            for (int i = 0; i < n; i++) {
                seq[i] = Integer.parseInt(br.readLine());
            }
            Arrays.sort(seq);

            int min = 0;
            for (int i : seq) {
                min = Math.max(min, Math.min(i, l - i));
            }
            sb.append(min).append("\n");
        }

        System.out.println(sb);
    }
}
