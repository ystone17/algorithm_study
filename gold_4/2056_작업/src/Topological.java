import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Topological {

    static int n, answer;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static List<List<Integer>> graph = new ArrayList<>();
    static int[] time, res, degree;

    public static void main(String[] args) throws IOException {

        n = Integer.parseInt(br.readLine());
        time = new int[n + 1];
        res = new int[n + 1];
        degree = new int[n + 1];
        for (int i = 0; i < n + 1; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());

            time[i] = t;

            int count = Integer.parseInt(st.nextToken());

            for (int j = 0; j < count; j++) {
                int v = Integer.parseInt(st.nextToken());
                graph.get(v).add(i);
                degree[i]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            res[i] = time[i];
            if (degree[i] == 0) q.add(i);
        }

        while (!q.isEmpty()) {
            Integer cur = q.poll();

            for (Integer next : graph.get(cur)) {
                res[next] = Math.max(res[next], res[cur] + time[next]);
                if (--degree[next] == 0) {
                    q.add(next);
                }
            }
            answer = Math.max(answer, res[cur]);

        }

        System.out.println(answer);
    }
}
