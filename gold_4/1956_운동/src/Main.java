import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int V, E, res = Integer.MAX_VALUE;
    static int[][] graph;

    public static void main(String[] args) throws IOException {

        st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        graph = new int[V + 1][V + 1];
        for (int[] ints : graph) {
            Arrays.fill(ints, (int) 1e7);
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            graph[u][v] = w;
        }

        for (int k = 1; k <= V; k++) {
            for (int u = 1; u <= V; u++) {
                for (int v = 1; v <= V; v++) {
                    if (u == v) continue;
                    if (graph[u][v] > graph[u][k] + graph[k][v]) {
                        graph[u][v] = graph[u][k] + graph[k][v];
                    }
                }
            }
        }


        for (int u = 1; u <= V; u++) {
            for (int v = 1; v <= V; v++) {
                if (u == v) continue;
                if (graph[u][v] != (int) 1e7 && graph[v][u] != (int) 1e7)
                    res = Math.min(res, graph[u][v] + graph[v][u]);
            }
        }

        if (res == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(res);
        }

    }
}
