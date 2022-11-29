import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int tc;

    static int len, n;
    static int[] before, after, inDegree;
    static List<List<Integer>> graph = new ArrayList<>();
    static Queue<Integer> q = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        tc = Integer.parseInt(br.readLine());
        while (tc-- > 0) {
            test();
        }
        System.out.println(sb);
    }

    static void test() throws IOException {
        len = Integer.parseInt(br.readLine());
        before = new int[len + 1];
        after = new int[len + 1];
        inDegree = new int[len + 1];
        graph = new ArrayList<>();
        for (int i = 0; i < len + 1; i++) {
            graph.add(new ArrayList<>());
        }
        q = new LinkedList<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= len; i++) {
            before[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i < before.length; i++) {
            for (int j = i + 1; j < before.length; j++) {
                graph.get(before[i]).add(before[j]);
                inDegree[before[j]]++;
            }
        }

        n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (graph.get(a).contains(b)) {
                int temp = a;
                a = b;
                b = temp;
            }

            graph.get(b).remove((Integer) a);
            graph.get(a).add(b);
            inDegree[a]--;
            inDegree[b]++;

        }


        for (int i = 1; i < inDegree.length; i++) {
            if (inDegree[i] == 0) {
                q.add(i);
            }
        }


        int idx = 1;
        while (!q.isEmpty()) {
            if (q.size() >= 2) {
                sb.append("IMPOSSIBLE").append("\n");
                return;
            }

            Integer cur = q.poll();
            after[idx++] = cur;

            for (Integer next : graph.get(cur)) {
                if (--inDegree[next] == 0) {
                    q.add(next);
                }
            }

        }

        if (idx <= len) {
            sb.append("IMPOSSIBLE").append("\n");
            return;
        }

        for (int i = 1; i < after.length; i++) {
            sb.append(after[i]).append(" ");
        }
        sb.append("\n");
    }
}
