import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int n, m;
    static List<List<Integer>> graph = new ArrayList<>();
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        for (int i = 0; i < n; i++) {
            boolean res = dfs(i, 0);
            if (res) {
                System.out.println(1);
                return;
            }
        }

        System.out.println(0);
    }

    static boolean dfs(int k, int cnt) {
        if (cnt >= 4) {
            return true;
        }

        visited[k] = true;

        for (Integer next : graph.get(k)) {
            if (visited[next]) continue;
            boolean res = dfs(next, cnt + 1);
            if (res) return true;
        }

        visited[k] = false;
        return false;
    }
}
