import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int n, l;
    static int[] seq;
    static Deque<Pos> deque = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());

        seq = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            seq[i] = Integer.parseInt(st.nextToken());
        }

        int a;
        for (int i = 0; i < n; i++) {
            a = Math.max(i - l + 1, 0);

            if (!deque.isEmpty() && deque.peekFirst().idx < a) {
                deque.pollFirst();
            }

            while (!deque.isEmpty() && deque.peekLast().num > seq[i]) {
                deque.pollLast();
            }

            deque.addLast(new Pos(seq[i], i));

            sb.append(deque.peekFirst().num).append(" ");
        }

        System.out.println(sb);
    }

    static class Pos {
        int num;
        int idx;

        public Pos(int num, int idx) {
            this.num = num;
            this.idx = idx;
        }
    }
}
