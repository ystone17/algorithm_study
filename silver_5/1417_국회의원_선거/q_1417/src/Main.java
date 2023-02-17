import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int n, me, cnt;
    static PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());

        me = Integer.parseInt(br.readLine());

        for (int i = 0; i < n - 1; i++) {
            pq.add(Integer.parseInt(br.readLine()));
        }

        while (!pq.isEmpty() && me <= pq.peek()) {
            me++;
            cnt++;
            int poll = pq.poll();
            pq.add(poll - 1);
        }

        System.out.println(cnt);
    }
}
