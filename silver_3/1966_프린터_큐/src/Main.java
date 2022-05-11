import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int tc, n, target;
    static PriorityQueue<Integer> pq;
    static Queue<Paper> q;

    public static void main(String[] args) throws IOException {
        tc = Integer.parseInt(br.readLine());

        while (tc-- > 0) {
            q = new LinkedList<>();
            pq = new PriorityQueue<>(Comparator.reverseOrder());
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            target = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                int weight = Integer.parseInt(st.nextToken());
                q.add(new Paper(i, weight));
                pq.add(weight);
            }

            int count = 0;
            while (!q.isEmpty()) {
                Paper cur = q.poll();
                if (cur.weight == pq.peek()) {
                    pq.poll();
                    count++;
                    if (cur.num == target) {
                        sb.append(count).append("\n");
                        break;
                    }
                } else {
                    q.add(cur);
                }
            }

        }
        System.out.println(sb);
    }

    static class Paper {
        int num;
        int weight;

        public Paper(int num, int weight) {
            this.num = num;
            this.weight = weight;
        }
    }

}
