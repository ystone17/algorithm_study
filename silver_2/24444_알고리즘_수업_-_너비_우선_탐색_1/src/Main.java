import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int v, e, start;
    static List<List<Integer>> graph = new ArrayList<>();
    static int[] visited;
    static Queue<Integer> q = new LinkedList<>();
    static Queue<Integer> route = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());

        v = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());
        start = Integer.parseInt(st.nextToken());

        for (int i = 0; i < v + 1; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        for (int i = 0; i < v + 1; i++) {
            Collections.sort(graph.get(i));
        }

        visited = new int[v + 1];

        bfs();

        Arrays.fill(visited, 0);
        int size = route.size();
        for (int i = 0; i < size; i++) {
            Integer v = route.poll();

            visited[v] = i + 1;
        }

        for (int i = 1; i < visited.length; i++) {
            sb.append(visited[i]).append("\n");
        }
        System.out.println(sb);
    }

    static void bfs() {
        q.add(start);
        visited[start] = 1;
        route.add(start);

        while (!q.isEmpty()) {
            Integer cur = q.poll();
            ;

            for (Integer next : graph.get(cur)) {
                if (visited[next] == 1) continue;
                visited[next] = 1;
                route.add(next);

                q.add(next);
            }
        }

    }
}
