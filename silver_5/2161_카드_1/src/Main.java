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

    static int n;
    static Deque<Integer> dq = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());

        for (int i = 1; i <= n; i++) {
            dq.add(i);
        }


        while (dq.size() != 1) {
            sb.append(dq.pollFirst()).append(" ");
            dq.addLast(dq.pollFirst());
        }

        sb.append(dq.poll());
        System.out.println(sb);
    }
}
