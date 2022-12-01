import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int k, n;
    static long max = 1;
    static int[] arr, temp;
    static PriorityQueue<Long> pq = new PriorityQueue<>();
    static Map<Long, Boolean> map = new HashMap<>();

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        k = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        arr = new int[k];
        temp = new int[k];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < k; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            pq.add((long)arr[i]);
        }


        for (int i = 0; i < n - 1; i++) {
            Long cur = pq.poll();

            for (int j : arr) {
                long next = cur * j;
                if (next >= ((long) 2 << 30)) {
                    continue;
                }
                if (map.containsKey(next)) continue;

                pq.add(next);
                map.put(next, true);
            }
        }

        System.out.println(pq.poll());
    }
}
