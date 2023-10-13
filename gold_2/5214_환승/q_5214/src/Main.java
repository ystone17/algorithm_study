import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int n, tubeSize, tubeMaxNum;
    static List<List<Integer>> graph = new ArrayList<>();
    static int[] dist, visited;
    static Queue<Integer> q = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        tubeSize = Integer.parseInt(st.nextToken());
        tubeMaxNum = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n + 1 + tubeMaxNum; i++) {
            graph.add(new ArrayList<>());
        }

        for (int tubeNum = 0; tubeNum < tubeMaxNum; tubeNum++) {
            st = new StringTokenizer(br.readLine());

            for (int i = 0; i < tubeSize; i++) {
                int station = Integer.parseInt(st.nextToken());
                graph.get(station).add(tubeNum + 1 + n);
                graph.get(tubeNum + 1 + n).add(station);
            }
        }

        dist = new int[n + 1 + tubeMaxNum];
        visited = new int[n + 1 + tubeMaxNum];

        q.add(1);
        dist[1] = 1;
        visited[1] = 1;

        while (!q.isEmpty()) {
            int cur = q.poll();

            for (int next : graph.get(cur)) {
                if (visited[next] == 1) {
                    continue;
                }
                visited[next] = 1;
                dist[next] = dist[cur] + 1;
                q.add(next);
            }
        }

        System.out.println(visited[n] == 1 ? dist[n] / 2 + 1 : -1);
    }
}
