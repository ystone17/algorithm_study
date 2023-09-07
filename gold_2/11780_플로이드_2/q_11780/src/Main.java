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

    static int n, m;
    static int[][] graph;
    static int[][] dist;
    static List<List<List<Integer>>> route = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        for (int i = 0; i <= n; i++) {
            List<List<Integer>> temp = new ArrayList<>();
            for (int j = 0; j <= n; j++) {
                temp.add(new ArrayList<>());
            }
            route.add(temp);
        }

        graph = new int[n + 1][n + 1];
        dist = new int[n + 1][n + 1];
        for (int i = 1; i < n + 1; i++) {
            Arrays.fill(graph[i], 123_456_789);
            Arrays.fill(dist[i], 123_456_789);
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());
            graph[from][to] = Math.min(graph[from][to], value);
            dist[from][to] = graph[from][to];
        }

        fluid();

        drawDist();
        System.out.println(sb);

        for (int y = 1; y <= n; y++) {
            for (int x = 1; x <= n; x++) {
                if(y==x) {
                    System.out.println(0);
                    continue;
                }
                List<Integer> integers = route.get(y).get(x);

                System.out.printf("%d -> %d cnt: %d ", y, x, integers.size() + 2);
                System.out.printf("%d ", y);
                System.out.print(integers);
                System.out.printf(" %d\n", x);
            }
        }
    }

    private static void drawDist() {
        for (int y = 1; y <= n; y++) {
            for (int x = 1; x <= n; x++) {
                sb.append(dist[y][x] == 123_456_789 ? 0 : dist[y][x]).append(" ");
            }
            sb.append("\n");
        }
    }

    static void fluid() {
        for (int y = 1; y <= n; y++) {
            for (int x = 1; x <= n; x++) {
                if (y == x) {
                    continue;
                }

                for (int mid = 1; mid <= n; mid++) {
                    if (mid == y || mid == x) {
                        continue;
                    }

                    if (dist[y][x] > dist[y][mid] + dist[mid][x]) {
                        dist[y][x] = dist[y][mid] + dist[mid][x];
                        route.get(y).get(x).add(mid);
                    }
                }
            }
        }
    }
}
