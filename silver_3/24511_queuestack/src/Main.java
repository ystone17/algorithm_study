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

    static Deque<Integer> dq = new LinkedList<>();

    static int n;
    static int[] queuestack;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        queuestack = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            queuestack[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            if (queuestack[i] == 0) {
                dq.addLast(Integer.parseInt(st.nextToken()));
                continue;
            }

            st.nextToken();
        }

        n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            dq.addFirst(Integer.parseInt(st.nextToken()));
            sb.append(dq.pollLast()).append(" ");
        }

        System.out.println(sb);
    }
}
