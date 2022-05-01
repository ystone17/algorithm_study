import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int tc, n;
    static long res;
    static PriorityQueue<Long> pq = new PriorityQueue<>();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        tc = Integer.parseInt(br.readLine());

        while (tc-- > 0) {
            res = 0;
            n = Integer.parseInt(br.readLine());

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                long e = Integer.parseInt(st.nextToken());
                pq.add(e);
            }

            while (pq.size() > 1) {
                long a = pq.poll();
                long b = pq.poll();

                res += a + b;
                pq.add(a + b);
            }

            sb.append(res).append("\n");
            pq.poll();
        }
        System.out.println(sb);
    }
}
