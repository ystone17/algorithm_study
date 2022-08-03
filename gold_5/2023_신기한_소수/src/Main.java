import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int n;
    static int[] first = {2, 3, 5, 7};

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());


        dfs(0, 0);
        System.out.println(sb);

    }

    static void dfs(int cnt, int value) {
        if (cnt == n) {
            sb.append(value).append("\n");
            return;
        }

        if (cnt == 0) {
            for (int i : first) {
                dfs(cnt + 1, i);
            }
            return;
        }
        for (int i = 1; i < 10; i += 2) {
            if (!isPrime(value * 10 + i)) continue;
            dfs(cnt + 1, value * 10 + i);
        }
    }

    static boolean isPrime(int k) {
        for (int i = 2; i <= Math.sqrt(k); i++) {
            if (k % i == 0) return false;
        }
        return true;
    }
}
