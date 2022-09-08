import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int x, sum = 64, cnt;
    static PriorityQueue<Integer> pq = new PriorityQueue<>();

    public static void main(String[] args) throws IOException {
        x = Integer.parseInt(br.readLine());

        pq.add(64);
        int cur, a;

        while (sum != x) {
            cur = pq.poll();
            a = cur / 2;

            if (sum - a >= x) {
                sum -= a;
                pq.add(a);
            } else {
                pq.add(a);
                pq.add(a);
            }
        }

        System.out.println(pq.size());
    }
}
