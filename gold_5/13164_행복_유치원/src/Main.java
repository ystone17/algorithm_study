import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int n, k, res;
    static int[] children;
    static PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        children = new int[n];

        children[0] = Integer.parseInt(st.nextToken());
        for (int i = 1; i < n; i++) {
            children[i] = Integer.parseInt(st.nextToken());
            pq.add(children[i] - children[i - 1]);
        }

        res = children[n - 1] - children[0];
        for (int i = 0; i < k - 1; i++) {
            res -= pq.poll();
        }

        System.out.println(res);
    }
}
