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

    static int v, m, e, answer;
    static int[] items;
    static int[][] dist;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        v = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());

        items = new int[v + 1];
        dist = new int[v + 1][v + 1];
        for (int i = 0; i < v + 1; i++) {
            Arrays.fill(dist[i], 1_000_000);
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < v; i++) {
            items[i + 1] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            dist[u][v] = w;
            dist[v][u] = w;
        }

        floyd();

        for (int i = 1; i <= v; i++) {
            int sum = items[i];
            for (int j = 1; j <= v; j++) {
                if(dist[i][j] <= m) sum += items[j];
            }
            answer = Math.max(answer, sum);
        }

        System.out.println(answer);
    }

    private static void floyd() {

        for (int k = 1; k <= v; k++) {
            for (int from = 1; from <= v; from++) {
                for (int to = 1; to <= v; to++) {
                    if (from == to) continue;
                    if (dist[from][to] > dist[from][k] + dist[k][to]) {
                        dist[from][to] = dist[from][k] + dist[k][to];
                    }
                }
            }
        }

    }
}
