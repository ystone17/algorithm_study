import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SimpleMain {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int tc;

    static int n;
    static int[] parents, isParent;

    public static void main(String[] args) throws IOException {
        tc = Integer.parseInt(br.readLine());

        while (tc-- > 0) {
            n = Integer.parseInt(br.readLine());

            parents = new int[n + 1];
            isParent = new int[n + 1];

            for (int i = 0; i < n - 1; i++) {
                st = new StringTokenizer(br.readLine());
                var parent = Integer.parseInt(st.nextToken());
                var child = Integer.parseInt(st.nextToken());

                parents[child] = parent;
            }

            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            while (a != 0) {
                isParent[a] = 1;
                a = parents[a];
            }

            while (b != 0) {
                if (isParent[b] == 1) {
                    sb.append(b).append("\n");
                    break;
                }

                b = parents[b];
            }
        }

        System.out.println(sb);
    }

}
