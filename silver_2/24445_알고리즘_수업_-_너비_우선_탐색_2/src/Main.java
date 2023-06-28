import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static Queue<Integer> q = new LinkedList<>();

    static int n, m, startNode;
    static List<List<Integer>> graph = new ArrayList<>();
    static int[] visited;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        startNode = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n + 1; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        for (int i = 0; i < n + 1; i++) {
            graph.get(i).sort(Collections.reverseOrder());
        }

        visited = new int[n + 1];

        q.add(startNode);

        int index = 1;
        while (!q.isEmpty()) {
            Integer cur = q.poll();

            if (visited[cur] != 0) {
                continue;
            }
            visited[cur] = index++;

            for (Integer next : graph.get(cur)) {
                if (visited[next] != 0) {
                    continue;
                }

                q.add(next);
            }
        }

        for (int i = 1; i < visited.length; i++) {
            sb.append(visited[i]).append("\n");
        }

        System.out.println(sb);
    }
}
