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

    static List<List<Integer>> graph = new ArrayList<>();
    static int v, e;
    static int[] dist, visited;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());

        v = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());

        for (int i = 0; i < v + 1; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            graph.get(start).add(end);
            graph.get(end).add(start);
        }

        dist = new int[v + 1];
        visited = new int[v + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[1] = 0;

        for (int phase = 0; phase < v - 1; phase++) {
            int cur = -1;
            int min = Integer.MAX_VALUE;

            for (int v = 1; v < dist.length; v++) {
                if (visited[v] == 1) continue;
                if (min > dist[v]) {
                    min = dist[v];
                    cur = v;
                }
            }
            visited[cur] = 1;

            for (Integer next : graph.get(cur)) {
                if (dist[cur] + 1 < dist[next]) {
                    dist[next] = dist[cur] + 1;
                }
            }
        }

        int max = -1;
        int idx = -1;
        int cnt = 0;
        for (int i = 1; i < dist.length; i++) {
            if (max < dist[i]) {
                max = dist[i];
                idx = i;
                cnt = 1;
                continue;
            }

            if (max == dist[i]) {
                cnt++;
            }
        }

        System.out.printf("%d %d %d", idx, max, cnt);
    }
}
