import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static PriorityQueue<String> pq = new PriorityQueue<>();
    static String s;

    public static void main(String[] args) throws IOException {
        s = br.readLine();

        for (int a = 1; a < s.length() - 1; a++) {
            for (int b = a + 1; b < s.length(); b++) {
                pq.add(solve(a, b));
            }
        }

        System.out.println(pq.poll());
    }

    static String solve(int a, int b) {
        StringBuilder sb = new StringBuilder();
        StringBuilder sb1;

        sb1 = new StringBuilder();
        sb1.append(s, 0, a).reverse();
        sb.append(sb1);

        sb1 = new StringBuilder();
        sb1.append(s, a, b).reverse();
        sb.append(sb1);

        sb1 = new StringBuilder();
        sb1.append(s, b, s.length()).reverse();
        sb.append(sb1);

        return sb.toString();
    }
}
