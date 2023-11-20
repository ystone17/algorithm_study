import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int n, idx;
    static List<List<Integer>> graph = new ArrayList<>();
    static int[] answerSeq, priority, visited, findSeq;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n + 1; i++) {
            graph.add(new ArrayList<>());
        }

        answerSeq = new int[n];
        findSeq = new int[n];
        priority = new int[n + 1];
        visited = new int[n + 1];

        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            answerSeq[i] = Integer.parseInt(st.nextToken());
            priority[answerSeq[i]] = i;
        }

        for (List<Integer> list : graph) {
            list.sort(Comparator.comparingInt(o -> priority[o]));
        }

        findSeq[idx++] = 1;
        visited[1] = 1;
        dfs(1);

        for (int i = 0; i < n; i++) {
            if (findSeq[i] != answerSeq[i]) {
                System.out.println(0);
                return;
            }
        }

        System.out.println(1);
    }

    private static void dfs(int cur) {
        for (Integer next : graph.get(cur)) {
            if (visited[next] == 1) {
                continue;
            }

            visited[next] = 1;
            findSeq[idx++] = next;
            dfs(next);
        }
    }
}
