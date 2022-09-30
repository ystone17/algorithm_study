import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringBuilder sbTemp = new StringBuilder();
    static StringTokenizer st;

    static int tc;

    static int size, cnt;
    static PriorityQueue<Integer> pq = new PriorityQueue<>();
    static Queue<Integer> q = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        tc = Integer.parseInt(br.readLine());

        while (tc-- > 0) {
            size = Integer.parseInt(br.readLine());

            sbTemp = new StringBuilder();
            pq.clear();
            q.clear();
            cnt = 0;

            for (int i = 0; i < size; i++) {
                if (i % 10 == 0) {
                    st = new StringTokenizer(br.readLine());
                }

                pq.add(Integer.parseInt(st.nextToken()));

                if (i % 2 == 0) {
                    for (int j = 0; j < i / 2; j++) {
                        q.add(pq.poll());
                    }
                    cnt++;
                    sbTemp.append(pq.peek()).append(" ");
                    while (!q.isEmpty()) {
                        pq.add(q.poll());
                    }
                }
            }
            sb.append(cnt).append("\n").append(sbTemp.toString()).append("\n");
        }
        System.out.println(sb);

    }
}
