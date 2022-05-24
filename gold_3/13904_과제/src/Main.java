import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static Map<Integer, List<Integer>> map = new HashMap<>();
    static int n, maxD, answer;

    public static void main(String[] args) throws IOException {
        read();
        solve();
        System.out.println(answer);
    }

    private static void read() throws IOException {
        n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int d = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            List<Integer> list = map.getOrDefault(d, new ArrayList<>());
            list.add(w);
            map.put(d, list);
            maxD = Math.max(maxD, d);
        }
    }

    private static void solve() {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for (int d = maxD; d > 0; d--) {
            List<Integer> list = map.get(d);
            if (list != null) {
                pq.addAll(list);
            }
            if (!pq.isEmpty()) answer += pq.poll();
        }

    }


}
