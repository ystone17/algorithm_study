import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int n;
    static int[][] dist;
    static PriorityQueue<Integer> pq = new PriorityQueue<>();

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        dist = new int[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            Arrays.fill(dist[i], 123456789);
        }

        while (true) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (a == -1) break;

            dist[a][b] = dist[b][a] = 1;
        }

        for (int i = 1; i <= n; i++) {
            for (int s = 1; s <= n; s++) {
                for (int e = 1; e <= n; e++) {
                    if (s == e) continue;
                    dist[s][e] = Math.min(dist[s][e], dist[s][i] + dist[i][e]);
                }
            }
        }

        int min = 123456789;
        for (int i = 1; i <= n; i++) {
            int max = 1;
            for (int j = 1; j <= n; j++) {
                if (dist[i][j] == 123456789) continue;
                if (max >= dist[i][j]) continue;

                max = dist[i][j];
            }

            if (min < max) continue;
            if (min == max) {
                pq.add(i);
                continue;
            }

            min = max;
            pq.clear();
            pq.add(i);
        }

        sb.append(String.format("%d %d\n", min, pq.size()));
        while (!pq.isEmpty()) {
            sb.append(pq.poll()).append(" ");
        }

        System.out.println(sb);
    }
}
