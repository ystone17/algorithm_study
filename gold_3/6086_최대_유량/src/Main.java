import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static final int A = 'A' - 65;
    static final int Z = 'Z' - 65;

    static Queue<Integer> q = new LinkedList<>();
    static int result;
    static int[][] capacities = new int[52][52];
    static int[][] flows = new int[52][52];
    static int[] route = new int[52];

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int u = calcNodeNum(st.nextToken());
            int v = calcNodeNum(st.nextToken());
            int capacity = Integer.parseInt(st.nextToken());

            capacities[u][v] += capacity;
            capacities[v][u] += capacity;
        }

        while (true) {
            Arrays.fill(route, -1);
            q.clear();

            route[A] = A;
            q.add(A);

            while (!(q.isEmpty()) && route[Z] == -1) {
                int cur = q.poll();

                for (int i = 0; i < capacities[cur].length; i++) {
                    if (capacities[cur][i] == 0) continue;
                    if (route[i] != -1) continue;
                    if (capacities[cur][i] - flows[cur][i] <= 0) continue;

                    route[i] = cur;
                    q.add(i);
                }
            }

            if (route[Z] == -1) break;

            int minFlow = Integer.MAX_VALUE;
            for (int r = Z; r != A; r = route[r]) {
                minFlow = Math.min(minFlow, capacities[route[r]][r] - flows[route[r]][r]);
            }

            for (int r = Z; r != A; r = route[r]) {
                flows[route[r]][r] += minFlow;
                flows[r][route[r]] -= minFlow;
            }

            result += minFlow;
        }

        System.out.println(result);
    }

    private static int calcNodeNum(String s) {
        int node = s.charAt(0) - 65;
        return node < 26 ? node : node - 6;
    }
}
