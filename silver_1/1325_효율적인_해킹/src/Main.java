import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int n, m;
    static List<List<Integer>> graph = new ArrayList<>();
    static Queue<Integer> q = new LinkedList<>();
    static boolean[] visited;
    static int[] count;

    public static void main(String[] args) throws IOException {
        String[] nm = br.readLine().split(" ");
        n = Integer.parseInt(nm[0]);
        m = Integer.parseInt(nm[1]);

        for (int i = 0; i < n + 1; i++) {
            graph.add(new ArrayList<>());
        }
        count = new int[n + 1];

        for (int i = 0; i < m; i++) {
            nm = br.readLine().split(" ");
            int a = Integer.parseInt(nm[0]);
            int b = Integer.parseInt(nm[1]);

            graph.get(a).add(b);
        }

        for (int i = 1; i <= n; i++) {
            bfs(i);
        }

        int max = 0;
        for (int i = 1; i <= n; i++) {
            max = Math.max(max, count[i]);
        }

        for (int i = 1; i <= n; i++) {
            if (count[i] == max) {
                sb.append(i).append(" ");
            }
        }

        System.out.println(sb.toString());
    }

    static void bfs(int k) {
        visited = new boolean[n + 1];
        q.clear();

        visited[k] = true;
        q.add(k);

        while (!q.isEmpty()) {
            int cur = q.poll();

            for (int next : graph.get(cur)) {
                if (visited[next]) continue;
                visited[next] = true;
                count[next]++;
                q.add(next);
            }
        }
    }
}
