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

        int max = 0;
        for (int i = 1; i <= n; i++) {
            visited = new boolean[10001];
            dfs(i);
        }

        for (int i = 1; i <= n; i++) {
            if (max < count[i]) {
                max = count[i];
            }
        }

        for (int i = 1; i <= n; i++) {
            if (max == count[i]) {
                sb.append(i).append(" ");
            }
        }
        System.out.println(sb.toString());


    }

    static void dfs(int k) {
        visited[k] = true;

        for (Integer next : graph.get(k)) {
            if (visited[next]) continue;
            count[next]++;
            dfs(next);
        }
    }
}
