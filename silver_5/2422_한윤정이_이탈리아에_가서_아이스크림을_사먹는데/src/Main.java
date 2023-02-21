import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int n, m, res;
    static int[] used;
    static int[][] notUsed;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        used = new int[n + 1];

        notUsed = new int[n + 1][n + 1];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            notUsed[a][b] = 1;
            notUsed[b][a] = 1;
        }

        for (int a = 1; a <= n; a++) {
            used[a] = 1;

            for (int b = 1; b <= n; b++) {
                if (used[b] == 1) continue;
                if (notUsed[b][a] == 1) continue;
                used[b] = 1;

                for (int c = 1; c <= n; c++) {
                    if (used[c] == 1) continue;
                    if (notUsed[c][a] == 1) continue;
                    if (notUsed[c][b] == 1) continue;

                    res++;
                }
                used[b] = 0;
            }
            used[a] = 0;
        }

        System.out.println(res / 6);
    }
}
