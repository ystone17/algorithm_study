import java.io.*;
import java.util.*;

public class Main {

    static int v, e;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int index = 0;
        while (true) {
            index++;
            st = new StringTokenizer(br.readLine());

            v = Integer.parseInt(st.nextToken());
            e = Integer.parseInt(st.nextToken());
            if (v == 0 && e == 0) break;
            int[] parent = new int[v + 1];
            int[] visited = new int[v + 1];
            List<List<Integer>> graph = new ArrayList<>();
            for (int i = 0; i < v + 1; i++) {
                graph.add(new ArrayList<>());
            }

            for (int i = 0; i < e; i++) {
                st = new StringTokenizer(br.readLine());

                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                graph.get(a).add(b);
                graph.get(b).add(a);
            }

            Queue<Integer> q = new LinkedList<>();

            int res = 0;
            for (int i = 1; i <= v; i++) {
                if (visited[i] != 0) continue;
                q.add(i);

                boolean isTree = true;
                while (!q.isEmpty()) {

                    int cur = q.poll();

                    for (Integer next : graph.get(cur)) {
                        if (parent[cur] == next) continue;
                        if (parent[next] != 0) {
                            isTree = false;
                        }
                        if (visited[next] == 1) continue;
                        parent[next] = cur;
                        visited[next] = 1;
                        q.add(next);
                    }
                }

                if (isTree) res++;
            }
            if (res == 0) {
                bw.write(String.format("Case %d: No trees.\n", index));
            } else if (res == 1) {
                bw.write(String.format("Case %d: There is one tree.\n", index));
            } else {
                bw.write(String.format("Case %d: A forest of %d trees.\n", index, res));
            }
        }
        bw.flush();
        bw.close();
        br.close();

    }
}
