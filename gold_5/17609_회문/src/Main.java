import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int n;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());

        while (n-- > 0) {
            sb.append(solution(br.readLine())).append("\n");
        }
        System.out.println(sb);
    }

    private static int solution(String s) {
        return req(0, s.length() - 1, s, false);
    }

    private static int req(int l, int r, String s, boolean safe) {
        if (l == r) {
            return safe ? 1 : 0;
        }

        while (s.charAt(l) == s.charAt(r) && l < r) {
            l++;
            r--;
        }

        if (l >= r) return safe ? 1 : 0;

        if (safe) return 2;

        int ll = req(l + 1, r, s, true);
        int rr = req(l, r - 1, s, true);

        return Math.min(ll, rr);
    }
}
