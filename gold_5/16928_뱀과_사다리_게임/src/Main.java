import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int l, s;
    static Map<Integer, Integer> ladders = new HashMap<>();
    static Map<Integer, Integer> snakes = new HashMap<>();
    static int[] visited = new int[100 + 1];

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());

        l = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());

        input(l, ladders);
        input(s, snakes);

        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        Arrays.fill(visited, 200);
        visited[1] = 0;

        while (!q.isEmpty()) {
            Integer cur = q.poll();

            for (int i = 6; i > 0; i--) {
                int next = cur + i;

                next = ladders.getOrDefault(next, next);
                next = snakes.getOrDefault(next, next);
                if (next > 100) continue;

                if (visited[next] < visited[cur] + 1) continue;
                visited[next] = visited[cur] + 1;
                q.add(next);
            }

        }

        System.out.println(visited[100]);

    }

    private static void input(int size, Map<Integer, Integer> snakes) throws IOException {
        for (int i = 0; i < size; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            snakes.put(u, v);
        }
    }

}
