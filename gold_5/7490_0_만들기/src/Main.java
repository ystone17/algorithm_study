import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static Queue<Character> q = new LinkedList<>();
    static int plusMinus = 1;
    static int tc, len;

    public static void main(String[] args) throws IOException {
        tc = Integer.parseInt(br.readLine());

        while (tc-- > 0) {
            len = Integer.parseInt(br.readLine());
            dfs(1, "");
            sb.append("\n");
        }

        System.out.println(sb);
    }

    private static void dfs(int cnt, String s) {
        if (cnt >= len) {
            s += cnt;
            if (isZero(s)) {
                sb.append(s).append("\n");
            }

            return;
        }

        dfs(cnt + 1, s + cnt + " ");
        dfs(cnt + 1, s + cnt + "+");
        dfs(cnt + 1, s + cnt + "-");
    }

    private static boolean isZero(String s) {
        for (char c : s.toCharArray()) {
            q.add(c);
        }

        plusMinus = 1;
        int res = 0;
        int temp = 0;
        while (!q.isEmpty()) {
            if (1 <= q.peek() - '0' && q.peek() - '0' <= 9) {
                temp *= 10;
                temp += q.poll() - '0';
                continue;
            }

            if (q.peek() == ' ') {
                q.poll();
                continue;
            }

            if (plusMinus == 1) {
                res += temp;
            } else {
                res -= temp;
            }
            temp = 0;
            if (q.poll() == '+') {
                plusMinus = 1;
            } else {
                plusMinus = -1;
            }
        }

        if (plusMinus == 1) {
            res += temp;
        } else {
            res -= temp;
        }

        return res == 0;
    }
}
