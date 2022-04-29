import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int V, E, x;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[][] dist;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());

        dist = new int[V + 1][V + 1];

        for (int i = 0; i < V + 1; i++) {
            for (int j = 0; j < V + 1; j++) {
                if (i == j) continue;
                dist[i][j] = 1_000_000;
            }
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            dist[u][v] = cost;
        }

        for (int k = 1; k < V + 1; k++) {
            for (int i = 1; i < V + 1; i++) {
                for (int j = 1; j < V + 1; j++) {
                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }
        }

        int answer = 0;
        for (int i = 1; i < V + 1; i++) {
            if (dist[i][x] != 1000000 && dist[x][i] != 1000000)
                answer = Math.max(answer, dist[i][x] + dist[x][i]);
        }

        System.out.println(answer);

    }

    static class Vertex {
        int num;
        int cost;

        public Vertex(int num, int cost) {
            this.num = num;
            this.cost = cost;
        }
    }
}
