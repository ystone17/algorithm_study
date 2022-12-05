import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int n, k;
    static Set<Integer> set = new HashSet<>();
    static PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        k = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            set.add(Integer.parseInt(st.nextToken()));
        }

        ArrayList<Integer> list = new ArrayList<>(set);
        Collections.sort(list);
        for (int i = 0; i < list.size() - 1; i++) {
            pq.add(list.get(i + 1) - list.get(i));
        }

        for (int i = 0; i < k - 1; i++) {
            pq.poll();
        }

        int res = 0;
        while (!pq.isEmpty()) {
            res += pq.poll();
        }

        System.out.println(res);

    }
}
