import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int n, k;
    static String s;
    static Deque<Character> dq = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        read();
        solve();
        System.out.println(sb);
    }

    private static void solve() {
        int cnt = k;
        char[] arr = s.toCharArray();
        for (char c : arr) {
            while (!dq.isEmpty() && cnt > 0 && dq.peekLast() < c) {
                dq.pollLast();
                cnt--;
            }

            dq.addLast(c);
        }

        for (int i = 0; i < n - k; i++) {
            sb.append(dq.poll());
        }
    }


    private static void read() throws IOException {
        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        s = br.readLine();

    }
}
