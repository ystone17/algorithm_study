import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int n, k;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        int sum = 0;
        for (int i = 0; i < k; i++) {
            sum += (i + 1);
        }

        if (sum > n) {
            System.out.println(-1);
            return;
        }

        if ((n - sum) % k == 0) {
            System.out.println(k - 1);
            return;
        }

        System.out.println(k);
    }
}
