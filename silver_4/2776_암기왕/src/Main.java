import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int tc, n, m;
    static Set<Integer> set = new HashSet<>();

    public static void main(String[] args) throws IOException {
        tc = Integer.parseInt(br.readLine());

        while (tc-- > 0) {
            set = new HashSet<>();
            n = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                set.add(Integer.parseInt(st.nextToken()));
            }


            m = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < m; i++) {
                sb.append(set.contains(Integer.parseInt(st.nextToken())) ? 1 : 0).append("\n");
            }
        }

        System.out.println(sb);
    }
}
