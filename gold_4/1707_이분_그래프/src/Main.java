import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int tc;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[] color = {1, 2};

    public static void main(String[] args) throws IOException {
        tc = Integer.parseInt(br.readLine());
        while (tc-- > 0) {
            if(solve()) System.out.println("YES");
            else System.out.println("NO");
        }
    }

    private static boolean solve() throws IOException {
        st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= V; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        int[] visited = new int[V + 1];
        Queue<Integer> q = new LinkedList<>();
        int colorIdx = 0;
        for (int i = 1; i <= V; i++) {
            if(visited[i] != 0) continue;
            visited[i] = color[colorIdx];
            q.add(i);
            while (!q.isEmpty()) {
                int size = q.size();
                colorIdx = (colorIdx + 1) % 2;
                for (int j = 0; j < size; j++) {
                    Integer poll = q.poll();

                    for (Integer next : graph.get(poll)) {
                        if(visited[next] == color[colorIdx]) continue;
                        if(visited[next] != 0) return false;
                        visited[next] = color[colorIdx];
                        q.add(next);
                    }
                }
            }
        }



        return true;
    }
}
