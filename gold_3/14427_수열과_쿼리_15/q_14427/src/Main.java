import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static PriorityQueue<Pos> pq = new PriorityQueue<>();
    static int n, cmdNum;
    static int[] seq;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        seq = new int[n + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            seq[i + 1] = Integer.parseInt(st.nextToken());
            pq.add(new Pos(seq[i + 1], i + 1));
        }

        cmdNum = Integer.parseInt(br.readLine());
        while (cmdNum-- > 0) {
            st = new StringTokenizer(br.readLine());

            int cmd = Integer.parseInt(st.nextToken());
            if (cmd == 1) {
                cmd1(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            } else {
                sb.append(cmd2()).append("\n");
            }
        }

        System.out.println(sb);
    }

    private static void cmd1(int idx, int value) {
        seq[idx] = value;
        pq.add(new Pos(value, idx));
    }

    private static int cmd2() {
        Pos cur;
        while (true){
            cur = pq.peek();
            if (seq[cur.idx] != cur.value) {
                pq.poll();
                continue;
            }

            break;
        }

        return cur.idx;
    }

    static class Pos implements Comparable<Pos> {
        int value;
        int idx;

        public Pos(int value, int idx) {
            this.value = value;
            this.idx = idx;
        }

        @Override
        public int compareTo(Pos o) {
            if (this.value != o.value) {
                return Integer.compare(value, o.value);
            }

            return Integer.compare(this.idx, o.idx);
        }
    }
}
