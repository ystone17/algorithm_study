import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int tc;
    static int k, m, p;
    static List<List<Integer>> graph = new ArrayList<>();
    static List<PriorityQueue<Integer>> strahlerRecord = new ArrayList<>();
    static int[] remainder;
    static int[] strahler;
    static Queue<Integer> q = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        tc = Integer.parseInt(br.readLine());

        while (tc-- > 0) {
            st = new StringTokenizer(br.readLine());
            k = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            p = Integer.parseInt(st.nextToken());

            graph.clear();
            strahlerRecord.clear();
            for (int i = 0; i < m + 1; i++) {
                graph.add(new ArrayList<>());
                strahlerRecord.add(new PriorityQueue<>(Comparator.reverseOrder()));
            }

            remainder = new int[m + 1];
            strahler = new int[m + 1];
            q.clear();

            for (int i = 0; i < p; i++) {
                st = new StringTokenizer(br.readLine());
                var from = Integer.parseInt(st.nextToken());
                var to = Integer.parseInt(st.nextToken());

                remainder[to]++;
                graph.get(from).add(to);
            }

            for (int i = 1; i < remainder.length; i++) {
                if (remainder[i] == 0) {
                    q.add(i);
                    strahler[i] = 1;
                }
            }

            while (!q.isEmpty()) {
                var cur = q.poll();

                for (Integer next : graph.get(cur)) {
                    strahlerRecord.get(next).add(strahler[cur]);
                    if (--remainder[next] == 0) {

                        var record = strahlerRecord.get(next);
                        var strahlerNum = 0;
                        while (!record.isEmpty()) {
                            var r = record.poll();

                            if (r > strahlerNum) {
                                strahlerNum = r;
                                continue;
                            }

                            if (r == strahlerNum) {
                                strahlerNum++;
                                break;
                            }

                            break;
                        }

                        strahler[next] = strahlerNum;
                        q.add(next);
                    }
                }
            }

            sb.append(String.format("%d %d\n", k, strahler[m]));
        }

        System.out.println(sb);
    }
}
