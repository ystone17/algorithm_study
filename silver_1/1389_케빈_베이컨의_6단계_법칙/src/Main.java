import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int v, e;
    static List<List<Integer>> graph = new ArrayList<>();
    static int[] visited;
    static Queue<Integer> q = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        v = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());
        for (int i = 0; i <= v; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            graph.get(v1).add(v2);
            graph.get(v2).add(v1);
        }

        int vNum = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 1; i <= v; i++) {
            visited = new int[v + 1];
            visited[i] = 1;
            q.add(i);
            int depth = 0;
            int count = 0;
            while (!q.isEmpty()) {

                int size = q.size();
                count += size * depth++;
                for (int j = 0; j < size; j++) {
                    int cur = q.poll();

                    for (Integer next : graph.get(cur)) {
                        if (visited[next] == 1) continue;
                        visited[next] = 1;
                        q.add(next);
                    }
                }
            }

            if (min > count) {
                vNum = i;
                min = count;
            }
        }
        System.out.println(vNum);
    }

}
