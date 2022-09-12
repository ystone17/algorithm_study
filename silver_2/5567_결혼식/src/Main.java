import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int n, m, res;
    static List<List<Integer>> graph = new ArrayList<>();
    static Queue<Integer> q = new LinkedList<>();
    static int[] visited;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        for (int i = 0; i < n + 1; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        visited = new int[n + 1];
        visited[1] = 1;
        q.add(1);

        for (int phase = 0; phase < 2; phase++) {
            int size = q.size();

            for (int i = 0; i < size; i++) {
                Integer cur = q.poll();

                for (Integer next : graph.get(cur)) {
                    if (visited[next] == 1) continue;
                    visited[next] = 1;
                    q.add(next);
                    res++;
                }
            }
        }

        System.out.println(res);
    }
}
