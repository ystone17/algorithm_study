import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static final String FAIL_MSG = "Oh no";

    static int n, m, k;
    static int[] prices, groupNum;
    static List<List<Integer>> graph = new ArrayList<>();
    static Queue<Integer> q = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        prices = new int[n + 1];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            prices[i + 1] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < n + 1; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            graph.get(u).add(v);
            graph.get(v).add(u);
        }


        groupNum = new int[n + 1];

        int total = 0;
        int num = 1;
        int min;
        for (int i = 1; i <= n; i++) {
            if (groupNum[i] != 0) {
                continue;
            }

            min = Integer.MAX_VALUE;
            q.clear();
            q.add(i);

            while (!q.isEmpty()) {
                var cur = q.poll();

                if (groupNum[cur] != 0) {
                    continue;
                }

                groupNum[cur] = num;
                min = Math.min(min, prices[cur]);

                for (var next : graph.get(cur)) {
                    if (groupNum[next] != 0) {
                        continue;
                    }

                    q.add(next);
                }
            }

            total += min;
        }

        System.out.println(total <= k ? total : FAIL_MSG);
    }
}
