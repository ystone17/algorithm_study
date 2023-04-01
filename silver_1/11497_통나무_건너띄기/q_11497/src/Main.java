import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuffer sb = new StringBuffer();

    static int tc;
    static int n;
    static int[] seq;
    static Deque<Integer> q;

    public static void main(String[] args) throws IOException {
        tc = Integer.parseInt(br.readLine());

        while (tc-- > 0) {
            sb.append(solve()).append("\n");
        }

        System.out.println(sb);
    }

    private static int solve() throws IOException {
        n = Integer.parseInt(br.readLine());
        seq = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            seq[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(seq);

        q = new ArrayDeque<>();

        q.add(seq[n - 1]);

        boolean flag = true;
        for (int i = seq.length - 2; i >= 0; i--) {
            if (flag) {
                q.addLast(seq[i]);
            } else {
                q.addFirst(seq[i]);
            }
            flag = !flag;
        }
        int res = 0;
        Integer[] temp = q.toArray(new Integer[0]);
        for (int i = 0; i < temp.length; i++) {
            Integer front = temp[i];
            Integer rear = temp[((i - 1) + temp.length) % temp.length];
            res = Math.max(res, Math.abs(front - rear));
        }
        return res;
    }
}
