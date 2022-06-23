import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int v, routeNum;
    static int[][] adj;
    static int[] route;

    public static void main(String[] args) throws IOException {
        v = Integer.parseInt(br.readLine());
        routeNum = Integer.parseInt(br.readLine());

        adj = new int[v][v];
        route = new int[routeNum];

        for (int i = 0; i < v; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < v; j++) {
                int w = Integer.parseInt(st.nextToken());
                if (w == 0) w = 1_000_000;
                adj[i][j] = w;
            }
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < routeNum; i++) {
            route[i] = Integer.parseInt(st.nextToken()) - 1;
        }

        for (int k = 0; k < v; k++) {
            for (int y = 0; y < v; y++) {
                for (int x = 0; x < v; x++) {
                    if (y == x) continue;
                    if (adj[y][x] > adj[y][k] + adj[k][x]) {
                        adj[y][x] = adj[y][k] + adj[k][x];
                    }
                }
            }
        }

        for (int i = 0; i < routeNum - 1; i++) {
            if (route[i] == route[i + 1]) continue;
            if (adj[route[i]][route[i + 1]] == 1_000_000) {
                System.out.println("NO");
                return;
            }
        }

        System.out.println("YES");
    }
}
