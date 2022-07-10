import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static final int INF = 100000000;
    static int vNum, eNum;
    static int[][] graph;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        vNum = Integer.parseInt(st.nextToken());
        eNum = Integer.parseInt(st.nextToken());

        graph = new int[vNum + 1][vNum + 1];
        for (int i = 0; i < vNum + 1; i++) {
            Arrays.fill(graph[i], INF);
        }

        for (int i = 0; i < eNum; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph[u][v] = 1;
        }

        for (int i = 1; i <= vNum; i++) {
            for (int u = 1; u <= vNum; u++) {
                for (int v = 1; v <= vNum; v++) {
                    if (u == v) continue;
                    if (graph[u][v] > graph[u][i] + graph[i][v]) {
                        graph[u][v] = graph[u][i] + graph[i][v];
                    }
                }
            }
        }

        int res = 0;

        for (int u = 1; u <= vNum; u++) {
            boolean ok = true;
            for (int v = 1; v <= vNum; v++) {
                if (u == v) continue;
                if (graph[u][v] == INF && graph[v][u] == INF) {
                    ok = false;
                    break;
                }
            }
            if (ok) res++;
        }

        System.out.println(res);
    }
}
