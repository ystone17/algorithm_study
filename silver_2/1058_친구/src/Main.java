import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int n, max;
    static int[][] graph;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());

        graph = new int[n][n];
        for (int i = 0; i < n; i++) {
            int j = 0;
            for (char c : br.readLine().toCharArray()) {
                graph[i][j] = c == 'N' ? 123_456_789 : 1;
                graph[j][i] = c == 'N' ? 123_456_789 : 1;
                j++;
            }
        }

        for (int u = 0; u < n; u++) {
            for (int v = 0; v < n; v++) {
                if (u == v) continue;
                for (int m = 0; m < n; m++) {
                    if (graph[u][v] > graph[u][m] + graph[m][v]) {
                        graph[u][v] = graph[u][m] + graph[m][v];
                    }
                }
            }
        }

        for (int[] row : graph) {
            int temp = 0;
            for (int i : row) {
                if (i <= 2) temp++;
            }
            max = Math.max(max, temp);
        }

        System.out.println(max);
    }
}
