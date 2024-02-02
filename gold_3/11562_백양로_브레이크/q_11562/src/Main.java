import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int n, k, q;
    static int[][] dist;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        dist = new int[n + 1][n + 1];
        for (int i = 0; i < n + 1; i++) {
            Arrays.fill(dist[i], 1_000_000_000);
        }

        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            dist[u][v] = 0;
            dist[v][u] = b == 0 ? 1 : 0;
        }

        for (int s = 1; s < n + 1; s++) {
            for (int e = 1; e < n + 1; e++) {
                if (s == e) {
                    continue;
                }
                for (int m = 1; m < n + 1; m++) {
                    if (dist[s][e] > dist[s][m] + dist[m][e]) {
                        dist[s][e] = dist[s][m] + dist[m][e];
                    }
                }
            }
        }

        for (int i = 1; i < n + 1; i++) {
            dist[i][i] = 0;
        }

        q = Integer.parseInt(br.readLine());
        for (int i = 0; i < q; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            sb.append(dist[a][b]).append("\n");
        }

        System.out.println(sb);
    }
}
